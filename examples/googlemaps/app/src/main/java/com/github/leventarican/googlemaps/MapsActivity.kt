package com.github.leventarican.googlemaps

import android.Manifest
import android.app.PendingIntent
import android.content.Intent
import android.content.pm.PackageManager
import android.content.res.Resources
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.Geofence
import com.google.android.gms.location.GeofencingClient
import com.google.android.gms.location.GeofencingRequest
import com.google.android.gms.location.LocationServices

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.MarkerOptions

private const val REQUEST_FOREGROUND_ONLY_PERMISSIONS_REQUEST_CODE = 34
private const val TAG = "#"

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap
    private lateinit var geofencingClient: GeofencingClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        geofencingClient = LocationServices.getGeofencingClient(this)
    }

    /**
     * This callback is triggered when the map is ready to be used.
     * we have a non-null instance of google map
     */
    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        // to get lat and lon: google maps > whats here OR emulator location
//        val mountEverest = LatLng(27.98831027677858, 86.92497201495814)
        val point = LatLng(41.0082, 28.9782)
//        map.addMarker(MarkerOptions().position(point))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 16f))

        // # map style
        kotlin.run {
            // incl. also custom map style; map style in a raw resource file
            try {
                val success = map.setMapStyle(MapStyleOptions.loadRawResourceStyle(this, R.raw.map_style))
                if (!success) {
                    Log.e(TAG, "map style (JSON) parsing failed")
                } else {
                    Log.d(TAG, "map style parsing successful")
                }
            } catch (e: Resources.NotFoundException) {
                Log.e(TAG, "JSON file not found: ", e)
            }
        }

        // # enable user location
        kotlin.run {
            // if no permission then request permission is execute
            val permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            val grant = PackageManager.PERMISSION_GRANTED
            if (grant == permission) {
                map.isMyLocationEnabled = true
            } else {
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
                    ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), REQUEST_FOREGROUND_ONLY_PERMISSIONS_REQUEST_CODE)
                }
            }
        }

        // # handle long press on map
        kotlin.run {
            map.setOnMapLongClickListener {
                map.clear()
                map.addMarker(MarkerOptions().apply {
                    position(it)
                })
                map.addCircle(CircleOptions().apply {
                    center(it)
                    radius(200.0)
                    strokeColor(Color.argb(255, 255, 0, 0))
                    fillColor(Color.argb(64, 255, 0, 0))
                    strokeWidth(4.0f)
                })
                val geofence = Geofence.Builder()
                    .setCircularRegion(it.latitude, it.longitude, 200.0f)
                    .setRequestId("1000")
                    .setTransitionTypes(Geofence.GEOFENCE_TRANSITION_ENTER)
                    .setLoiteringDelay(5000)
                    .setExpirationDuration(Geofence.NEVER_EXPIRE)
                    .build()
                val request = GeofencingRequest.Builder()
                    .addGeofence(geofence)
                    .setInitialTrigger(GeofencingRequest.INITIAL_TRIGGER_ENTER)
                    .build()
                val intent = Intent(this, GeofenceBroadcastReceiver::class.java)
                val pendingIntent = PendingIntent.getBroadcast(this, 2000, intent, PendingIntent.FLAG_UPDATE_CURRENT)
                geofencingClient.addGeofences(request, pendingIntent)
                    .addOnSuccessListener { Log.d(TAG, "geofence added") }
                    .addOnFailureListener { Log.d(TAG, "FAILURE: adding geofence") }
            }
        }
    }

    // callback for permission result
    // handle no permission so request for it is done
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        if (requestCode == REQUEST_FOREGROUND_ONLY_PERMISSIONS_REQUEST_CODE) {
            Log.d(TAG, "onRequestPermissionsResult")
        }
    }

    /**
     * create options menu.
     * inflate menu resource map_options.xml to options menu
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inf = menuInflater
        inf.inflate(R.menu.map_options, menu)
        return true
    }

    /**
     * options menu item selected: what should we do then?
     * change map type: normal, hybrid, satellite, terrain
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean =
        when (item.itemId) {
            R.id.normal_map -> {
                map.mapType = GoogleMap.MAP_TYPE_NORMAL
                true
            }
            R.id.hybrid_map -> {
                map.mapType = GoogleMap.MAP_TYPE_HYBRID
                true
            }
            R.id.satellite_map -> {
                map.mapType = GoogleMap.MAP_TYPE_SATELLITE
                true
            }
            R.id.terrain_map -> {
                map.mapType = GoogleMap.MAP_TYPE_TERRAIN
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
}
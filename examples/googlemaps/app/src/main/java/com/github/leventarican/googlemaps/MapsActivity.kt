package com.github.leventarican.googlemaps

import android.Manifest
import android.annotation.SuppressLint
import android.app.PendingIntent
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.core.app.ActivityCompat
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
import com.google.android.gms.maps.model.MarkerOptions

private const val PERMISSION_REQUEST_CODE = 34
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
        val point = LatLng(41.0082, 28.9784)
//        map.addMarker(MarkerOptions().position(point))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 16f))

        // # map style
//        kotlin.run {
//            // incl. also custom map style; map style in a raw resource file
//            try {
//                val success = map.setMapStyle(MapStyleOptions.loadRawResourceStyle(this, R.raw.map_style))
//                if (!success) {
//                    Log.e(TAG, "map style (JSON) parsing failed")
//                } else {
//                    Log.d(TAG, "map style parsing successful")
//                }
//            } catch (e: Resources.NotFoundException) {
//                Log.e(TAG, "JSON file not found: ", e)
//            }
//        }

        // # enable user location
        kotlin.run {
            val permission = ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            if (permission == PackageManager.PERMISSION_GRANTED) {
                Log.d(TAG, "permission available: draw user location and bearing")
                map.isMyLocationEnabled = true
            } else {
                Log.d(TAG, "no permission: request permission")
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), PERMISSION_REQUEST_CODE)
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
                    strokeColor(Color.argb(255, 0, 255, 0))
                    fillColor(Color.argb(64, 0, 255, 0))
                    strokeWidth(4.0f)
                })
                val geofence = Geofence.Builder().setCircularRegion(it.latitude, it.longitude, 200.0f).setRequestId("GEOFENCE_ID").setTransitionTypes(Geofence.GEOFENCE_TRANSITION_ENTER).setLoiteringDelay(5000).setExpirationDuration(Geofence.NEVER_EXPIRE).build()
                val request = GeofencingRequest.Builder().addGeofence(geofence).setInitialTrigger(GeofencingRequest.INITIAL_TRIGGER_ENTER).build()
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
        if (requestCode == PERMISSION_REQUEST_CODE) {
            Log.d(TAG, "onRequestPermissionsResult")
            if (grantResults.contains(PackageManager.PERMISSION_GRANTED)) {
                Log.d(TAG, "permission granted")
                @SuppressLint("MissingPermission")
                map.isMyLocationEnabled = true
            } else {
                Log.d(TAG, "we have no no permissions. shutdown now.")
            }
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
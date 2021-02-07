package com.github.leventarican.googlemaps

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map: GoogleMap
    private val TAG = MapsActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * This callback is triggered when the map is ready to be used.
     * we have a non-null instance of google map
     */
    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap

        // to get lat and lon: google maps > whats here
        val mountEverest = LatLng(27.98831027677858, 86.92497201495814)
        val zoom = 5f
        map.addMarker(MarkerOptions().position(mountEverest).title("Mount Everest"))
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(mountEverest, zoom))

        // incl. also custom map style
//        map.mapType = GoogleMap.MAP_TYPE_SATELLITE
        setMapStyle(googleMap)
    }

    /**
     * map style in a raw resource file
     */
    private fun setMapStyle(map: GoogleMap) {
        try {
            val success = map.setMapStyle(MapStyleOptions.loadRawResourceStyle(this, R.raw.map_style))
            if (!success) {
                Log.e(TAG, "map style (JSON) parsing failed")
            }
        } catch (e: Resources.NotFoundException) {
            Log.e(TAG, "JSON file not found: ", e)
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
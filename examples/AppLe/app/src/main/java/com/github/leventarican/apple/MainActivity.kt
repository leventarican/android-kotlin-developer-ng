package com.github.leventarican.apple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView

/**
 * the main activity / single activity app
 */
class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var drawerLayout: DrawerLayout

    // you will find AppBarConfiguration in package navigation-ui-ktx
    // so add it in gradle file
    private lateinit var appbarConfig: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        connectNavigationAppbar()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appbarConfig) || super.onSupportNavigateUp()
    }

    // connect everything together: navigation drawer, navigation controller, app bar
    private fun connectNavigationAppbar(): Unit {
        setSupportActionBar(findViewById(R.id.toolbar))
        navController = findNavController(R.id.navigation_host_fragment)
        drawerLayout = (findViewById(R.id.drawer_layout))
        appbarConfig = AppBarConfiguration.Builder(R.id.screen0).setDrawerLayout(drawerLayout).build()
        setupActionBarWithNavController(navController, appbarConfig)
        findViewById<NavigationView>(R.id.navigation_view).setupWithNavController(navController)
    }
}

/*
set content view:
* with data binding
    * https://github.com/google-developer-training/android-kotlin-fundamentals-apps/blob/master/AboutMeDataBinding/app/src/main/java/com/example/android/aboutme/MainActivity.kt
    * binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    * or DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
* for fragments
    * https://developer.android.com/codelabs/kotlin-android-training-create-and-add-fragment?index=..%2F..android-kotlin-fundamentals#3
    * val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater, R.layout.fragment_title,container,false)
*/

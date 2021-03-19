package com.github.leventarican.underconstruction

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.github.leventarican.underconstruction.databinding.ActivityMainBinding

/**
 * DONE: back button does not work. reset data to 0. if not it will navigate always to screen 1
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // we are using ViewBinding.
        // with the binding instance we inflate the layout.
        // then we set the content view
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // we also use a toolbar.
        // remember that a Toolbar is not an ActionBar.
        // that's why we use this function where ToolBar acts as a ActionBar.
        // we also edit AndroidManifest.xml and add AppBarLayout to the layout file.
        setSupportActionBar(binding.toolbar)

        // next, we want to add navigation to the app bar.
        // this means we will have a UP button in the app bar.
        // to do this we say this is the activity and this is the navigation host.
        NavigationUI.setupActionBarWithNavController(this, findNavController(R.id.navigationHost))
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.navigationHost)
        val appBarConfiguration = AppBarConfiguration.Builder().build()
        return NavigationUI.navigateUp(navController, appBarConfiguration)
    }
}

package com.github.leventarican.underconstruction

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.onNavDestinationSelected
import com.github.leventarican.underconstruction.databinding.ActivityMainBinding

/**
 * TODO: implement binding adapters
 * DONE: implement options menu (incl. menu.xml)
 * DONE: implement navigation UP with Navigation UI
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
        // we also need to override onSupportNavigateUp() method.
        NavigationUI.setupActionBarWithNavController(this, findNavController(R.id.navigationHost))

        // next, we want also a options menu / overflow menu in the app bar.
        // for that purpose we implement onCreateOptionsMenu() to show the menu
        // and onOptionsItemSelected to implement item -> destination.
        // NOTE, that menu item id (navigation_menu.xml) is same as navigation destination id (navigation.xml)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.navigation_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = findNavController(R.id.navigationHost)
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.navigationHost)
        val appBarConfiguration = AppBarConfiguration.Builder().build()
        return NavigationUI.navigateUp(navController, appBarConfiguration)
    }
}

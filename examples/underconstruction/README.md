# under construction

This code base make use of architecture components, navigation components.
Here is a list of the used components and the respective 

* ViewModel and LiveData
    * Screen0*
    * screen0_fragment.xml
* ViewBinding
    * MainActivity: no <layout> needed for (view) binding
    * build.gradle: viewBinding = true
* Navigation
    * NavigationUI
    * navigation_menu.xml: item id references to navigation id 
    * navigation.xml
    * MainActivity: onSupportNavigateUp
    * build.gradle: navigation-ui-ktx, navigation-fragment-ktx, androidx.navigation.safeargs.kotlin (plugin)
* DataBinding
    * Screen0Fragment
    * Screen0ViewModel
    * screen0_fragment.xml: <layout>, <data>
    * build.gradle: dataBinding = true
* Data Binding: Binding Adapters
    * BindingAdapters
    * screen0_fragment.xml: code="@{true}"
    * build.gradle: kotlin-kapt
* App bar
    * activity_main.xml: AppBarLayout
    * MainActivity: setSupportActionBar, setupActionBarWithNavController
    * AndroidManifest.xml: NoActionBar
* Options menu
    * onCreateOptionsMenu, onOptionsItemSelected
* Extension functions
    * extension for fragments: Extensions.kt
* Navigation Drawer
    * navigation_drawer_header.xml
    * activity_main.xml: DrawerLayout as root layout

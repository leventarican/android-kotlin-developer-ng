# Bakery Store

* create a _navigation_ resource file `navigation.xml`
* dependencies `navigation-fragment-ktx` and `navigation-ui-ktx` in app build gradle will be automatically added
* now we need a navigation host which we define in our `activity_main.xml`.
* for inflating we will using data binding
    * add build feature in app / module build.gradle file
    * use `DataBindingUtil` class for inflating
    * wrap layouts in layout files with `<layout>`  

## screens
* Login
* Welcome
* Instructions screen
* Listing screen
    * once Login / Welcome / Instruction screen done pop up these screens 
    * in other words, when back button is pressed leave app
* Detail screens
    * will use `<data>` element from Data Binding

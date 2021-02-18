# Fragment with Data Binding
* example of how to use Fragment with data binding
* in order to have a __binding object__ we need to define a __data binding layout file__
    * we can achieve this by wrapping existing layout file with `<layout>` tag
    * afterwords we have a binding object. e.g. `FragmentTitleBinding`
* for inflating the binding layout file we use `DataBindingUtil`
* the fragment is included into the activity by using the `<fragment>` tag

## Links
* https://developer.android.com/topic/libraries/data-binding/expressions
* https://developer.android.com/reference/android/databinding/DataBindingUtil#inflate
* https://developer.android.com/codelabs/kotlin-android-training-create-and-add-fragment/index.html#3
* https://developer.android.com/codelabs/kotlin-android-training-data-binding-basics/index.html#5
* https://developer.android.com/topic/libraries/view-binding    // view binding (!= data binding)
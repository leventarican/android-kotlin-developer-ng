# View Binding
* View Binding is __not__ Data Binding

## Setup
* enable view binding in build file

## Concept
* for each layout file a respective __binding class__ is __generated__
* if you want to use the binding class then
    * call the static method inflate to get an __instance__ of the binding class
    * and assign this instance to a variable
* the binding instance has also the root view of the corresponding layout file
    * so get the root view and set it as content view

## Links
* https://developer.android.com/topic/libraries/view-binding
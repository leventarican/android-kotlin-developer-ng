# App Layout

## Data Binding
* if our view hierarchy is large then traversing / searching (findviewbyid) a view can be expensive
* thus we use data binding (pattern). the compiler generates a helper / binding class 
* activate data binding
```
buildFeatures {
         dataBinding true
}
```
* use layout element to wrap the layout file
```
<layout>
    <LinearLayout>
    ...
</layout>
```
* for binding data we need to create a `data` class. e.g. `com.github.leventarican.applayout.Data`
* we also create a `<data>` element where we define our reference / variable
* finally we reference / use the variable. see example `activity_main.xml`

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

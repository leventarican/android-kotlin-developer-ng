# App Le - Under construction

## RecyclerView
In order to use `RecyclerView` you need to setup following pieces:
* item: our data
* adapter: converts data/item to `RecyclerView`'s format. Check also code comment.
* viewholders: pool of reuse views
* recyclerview: `RecyclerView` interacts with `ViewHolder`

### Now we implement our logic
* create class `Datasource`: as the name suggests the data provider
* create data class `ProgrammingLang`: our entity

### Transform model to android
Next we need a way to take the data from data source and format it to `RecyclerView`'s format
The transformation is done with Adapters.
> Adapter is a __design pattern__ that adapts the data into something that understands `RecyclerView` 

## Links
* https://developer.android.com/codelabs/basic-android-kotlin-training-recyclerview-scrollable-list?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-kotlin-unit-2-pathway-3%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-training-recyclerview-scrollable-list#3

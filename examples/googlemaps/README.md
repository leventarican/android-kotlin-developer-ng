# App using Google Maps and Geofencing

* create new project with template `Google Maps Activity`
* the template will generate a two files for the API key
```
src/debug/res/values/google_maps_api.xml
src/release/res/values/google_maps_api.xml
```
* to create an API key copy an follow the provided link
* a google cloud project will also be created if you don't have already one 
    * to change project name: `IAM & manage > resource management`
* copy API key in .xml file
* run app

## Style Google Maps
* https://mapstyle.withgoogle.com/ or with new cloud style: `Google Maps Platform > Map Styles`
* customize your map then export as json
* in app project: `new resource directory > name: raw`
* create a new file `map_style.json` in `raw` folder and paste json cody into it

## Geofencing
* use a broadcast receiver to listen to the geofence transitions

### Testing with emulator
* add a geofence (circle radius) near to user location with long click 
* define a route with entering the geofence: `emulator > location > routes > play route`
* when user crosses (enters) the geofence cirle a broadcast receiver will catch the event

### Configuraton
* add dependency to app gradle file
```
implementation 'com.google.android.gms:play-services-location:17.0.0'
```
* add permission and receiver to manifest file
```
<uses-permission android:name="android.permission.ACCESS_BACKGROUND_LOCATION" />

<receiver android:name=".GeofenceBroadcastReceiver" android:enabled="true" android:exported="true" />
```

## Links
* https://developers.google.com/maps
* https://developer.android.com/codelabs/advanced-android-kotlin-training-geofencing
* https://developer.android.com/training/location/geofencing

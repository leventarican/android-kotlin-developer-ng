# App using Google Maps

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

## Links
* https://developers.google.com/maps

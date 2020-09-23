# REST API for searching city info
REST API for searching information about cities and city places.
<p>Project has controllers and services for different search methods.</p>
<p>Used Google Place API, Google Custom Search API, Google Knowledge Graph Search API, Open Weather Map API.
Also used search in Wikipedia.</p>

Examples:
<p> Google Place Api GET request - /getCity/Vinnytsia:</p>

```json
{
  "results": [
    {
      "formattedAddress": "Vinnytsia, Vinnytsia Oblast, Ukraine, 21000",
      "geometry": {
        "location": {
          "lat": 49.233083,
          "lng": 28.4682169
        },
        "viewport": {
          "northeast": {
            "lat": 49.27902,
            "lng": 28.5710879
          },
          "southwest": {
            "lat": 49.190448,
            "lng": 28.3681799
          }
        }
      },
      "name": "Vinnytsia",
      "icon": "https://maps.gstatic.com/mapfiles/place_api/icons/geocode-71.png",
      "placeId": "ChIJiWRaGWVbLUcR_nTd7lnh1Ms",
      "rating": 0.0,
      "types": [
        "locality",
        "political"
      ],
      "photos": [
        {
          "photoReference": "CmRaAAAAJfOE3UBuk3opmExAy-HrNdmJUSxucFcQ733jWLS37_acbGf325FZ1seBOndKMThml7B1O-xrXH3WrxFJLNTPfOzVHzV-OHXXTqXxrckarqAlkQNqmK7Km50wFuiUcEFnEhBtyE5cLz_Q7B39-pJ6EWXxGhQyQyiQhQ26HnivCDpfRcq2YkdS8A",
          "height": 2268,
          "width": 4032,
          "htmlAttributions": [
            "\u003ca href\u003d\"https://maps.google.com/maps/contrib/116719957841061101835\"\u003ePavel Ufimtsev\u003c/a\u003e"
          ]
        }
      ],
      "permanentlyClosed": false,
      "userRatingsTotal": 0
    }
  ],
  "htmlAttributions": []
}
```

<p>Open Weather Map API GET request - /getWeather/Vinnytsia:</p>

```json
{
  "coord" : {
    "lon" : 28.48,
    "lat" : 49.23
  },
  "weather" : [ {
    "id" : 800,
    "main" : "Clear",
    "description" : "clear sky",
    "icon" : "01n"
  } ],
  "base" : "stations",
  "main" : {
    "temp" : 13.72,
    "feels_like" : 9.58,
    "temp_min" : 13.72,
    "temp_max" : 13.72,
    "pressure" : 1013,
    "humidity" : 37,
    "sea_level" : 1013,
    "grnd_level" : 985
  },
  "visibility" : 10000,
  "wind" : {
    "speed" : 2.93,
    "deg" : 148
  },
  "clouds" : {
    "all" : 1
  },
  "dt" : 1600893563,
  "sys" : {
    "country" : "UA",
    "sunrise" : 1600833259,
    "sunset" : 1600876947
  },
  "timezone" : 10800,
  "id" : 689558,
  "name" : "Vinnytsia",
  "cod" : 200
}
```

<p>Wikipedia GET request - /getWiki/Vinnytsia:</p>

```text
Vinnytsia
Вінниця
City of regional significance 
Ukrainian  transcription(s)
 • National Vinnytsia
 • ALA-LC Vinnytsi͡a
 • BGN/PCGN Vinnytsya
 • Scholarly Vinnycja
 
 Flag Coat of arms
Nickname(s): pearl of Podilia
 VinnytsiaShow map of Vinnytsia Oblast VinnytsiaShow map of Ukraine
Coordinates: 49°14′N 28°29′E﻿ / ﻿49.233°N 28.483°E﻿ / 49.233; 28.483 
Coordinates : 49°14′N 28°29′E﻿ / ﻿49.233°N 28.483°E﻿ / 49.233; 28.483 
Country  Ukraine 
Oblast  Vinnytsia Oblast 
Raion Vinnytsia City Municipality
Founded1363
Government
 • Mayor Serhiy Morhunov 
Area
 • City of regional significance 113,2 km2 (437 sq mi)
Population (2015)[1] 
 • City of regional significance 372,484
 • Density1,066/km2 (2,760/sq mi)
 • Metro 660,000
Time zones UTC+2
UTC+3
Postal code 21000-
Area code(s) +380 432
Sister cities Birmingham , Kielce , Peterborough , Rîbnița 
Websitevmr.gov.ua <http://vmr.gov.ua>
```

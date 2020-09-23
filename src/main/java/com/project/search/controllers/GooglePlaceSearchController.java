package com.project.search.controllers;

import com.project.search.services.SearchWithParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GooglePlaceSearchController {

    @Autowired
    private SearchWithParamService googleSearchService;

    @GetMapping(value = "/getCity/{cityName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String searchCityInfo(@PathVariable String cityName) {
        return googleSearchService.searchByKeyword(cityName);
    }

    @GetMapping(value = "/getCity/{cityName}/{places}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String searchCityAndPlaces(@PathVariable("cityName") String cityName, @PathVariable("places") String places) {
        return googleSearchService.searchByKeywordAndParam(cityName, places);
    }

}

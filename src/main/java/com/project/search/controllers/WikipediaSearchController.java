package com.project.search.controllers;

import com.project.search.services.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WikipediaSearchController {

    @Autowired
    @Qualifier("WikiSearch")
    private SearchService wikiSearchService;

    @GetMapping(value = "/getWiki/{cityName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String searchCityInfo(@PathVariable String cityName) {
        return wikiSearchService.searchByKeyword(cityName);
    }
}

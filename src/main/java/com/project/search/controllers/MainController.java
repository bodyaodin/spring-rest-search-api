package com.project.search.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping(value = "/")
    public String main() {
        return "<h3>Type city name you want to find in Google Place: /getCity/{cityName}</h3>" +
                "<h3>Type city name and places type (restaurants, pubs, parks etc.) you want to find in Google Place: /getCity/{cityName}/{places}</h3>" +
                "<h3>Type city name you want to find in Wikipedia: /getWiki/{cityName}</h3>" +
                "<h3>Type city name you want to find weather in Open Weather Map: /getWeather/{cityName}</h3>" +
                "<h3>Type city name you want to find info about in Google Search: /getInfo/{cityName}</h3>" +
                "<h3>Type city name you want to find info about in Google Knowledge Graph: /getKGInfo/{cityName}</h3>";
    }
}

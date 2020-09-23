package com.project.search.services.impl;

import com.google.gson.Gson;
import com.google.maps.GeoApiContext;
import com.google.maps.PlacesApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.PlacesSearchResponse;
import com.project.search.services.SearchWithParamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
public class GooglePlaceSearchServiceImpl implements SearchWithParamService {

    @Autowired
    private GeoApiContext context;

    @Autowired
    private Gson gson;

    @Override
    public String searchByKeyword(String keyword) {
        try {
            PlacesSearchResponse response = PlacesApi
                    .textSearchQuery(context, keyword)
                    .await();

            return gson.toJson(response);
        } catch (ApiException | InterruptedException | IOException exception) {
            log.error("Can't find such information!", exception);
            return "Can't find such information!";
        }
    }

    @Override
    public String searchByKeywordAndParam(String keyword, String param) {
        return searchByKeyword(keyword + " " + param);
    }
}

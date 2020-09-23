package com.project.search.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.search.services.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@Slf4j
@Service
@Qualifier("WeatherSearch")
public class OpenWeatherMapSearchServiceImpl implements SearchService {

    @Autowired
    private ObjectMapper mapper;

    @Value("${open.weather.map.api.key}")
    private String apiKey;

    @Value("${open.weather.map.api.url}")
    private String url;

    @Override
    public String searchByKeyword(String keyword) {
        String searchUrl = String.format(url, keyword, apiKey);

        try {
            URL url = new URL(searchUrl);
            URLConnection conn = url.openConnection();

            return mapper
                    .readTree(getResult(conn))
                    .toPrettyString();
        } catch (IOException exception) {
            log.error("Can't find such information!", exception);
            return "Can't find such information!";
        }
    }

    private String getResult(URLConnection conn) throws IOException {
        StringBuilder result = new StringBuilder();
        try (BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
        }
        return result.toString();
    }
}

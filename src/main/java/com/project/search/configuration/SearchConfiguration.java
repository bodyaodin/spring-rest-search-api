package com.project.search.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.customsearch.Customsearch;
import com.google.api.services.customsearch.CustomsearchRequestInitializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.project.search.convertors.HtmlToPlainText;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;
import java.security.GeneralSecurityException;

@Configuration
@PropertySource(value = {
        "classpath:application.properties",
        "classpath:apiKeys.properties"
})
public class SearchConfiguration {

    @Value("${custom.search.api.key}")
    private String customSearchApiKey;

    @Value("${google.place.search.api.key}")
    private String googlePlaceApiKey;


    @Bean(name = "mapper")
    public ObjectMapper getMapper() {
        return new ObjectMapper();
    }

    @Bean(name = "gson")
    public Gson getGson() {
        return new GsonBuilder()
                .setPrettyPrinting()
                .create();
    }

    @Bean(name = "customSearch")
    public Customsearch getCustomSearch() throws GeneralSecurityException, IOException {
        return new Customsearch
                .Builder(GoogleNetHttpTransport.newTrustedTransport(), JacksonFactory.getDefaultInstance(), null)
                .setGoogleClientRequestInitializer(new CustomsearchRequestInitializer(customSearchApiKey))
                .build();
    }

    @Bean(name = "GeoApiContext")
    public GeoApiContext getGeoApiContext() {
        return new GeoApiContext.Builder()
                .apiKey(googlePlaceApiKey)
                .build();
    }

    @Bean(name = "httpTransport")
    public HttpTransport getHttpTransport() {
        return new NetHttpTransport();
    }

    @Bean(name = "httpRequestFactory")
    public HttpRequestFactory getHttpRequestFactory(HttpTransport httpTransport) {
        return httpTransport.createRequestFactory();
    }

    @Bean(name = "htmlToPlainText")
    public HtmlToPlainText getHtmlToPlainText() {
        return new HtmlToPlainText();
    }

}

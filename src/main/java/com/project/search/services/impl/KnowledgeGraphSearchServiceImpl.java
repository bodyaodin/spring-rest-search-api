package com.project.search.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.project.search.services.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
@Qualifier("KnowledgeGraphSearch")
public class KnowledgeGraphSearchServiceImpl implements SearchService {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private HttpRequestFactory requestFactory;

    @Value("${kgsearch.api.key}")
    private String apiKey;

    @Value("${kgsearch.api.url}")
    private String searchUrl;

    @Value("${kgsearch.api.type}")
    private String searchType;

    @Value("${kgsearch.api.limit}")
    private String searchLimit;

    @Value("${kgsearch.api.indent}")
    private String searchIndent;

    @Override
    public String searchByKeyword(String keyword) {
        try {
            HttpRequest request = requestFactory.buildGetRequest(buildUrl(keyword));
            HttpResponse httpResponse = request.execute();

            return getMappedResult(httpResponse);
        } catch (IOException exception) {
            log.error("Can't find such information!", exception);
            return "Can't find such information!";
        }
    }

    private GenericUrl buildUrl(String keyword) {
        GenericUrl url = new GenericUrl(searchUrl);
        url.put("query", keyword);
        url.put("types", searchType);
        url.put("limit", searchLimit);
        url.put("indent", searchIndent);
        url.put("key", apiKey);

        return url;
    }

    private String getMappedResult(HttpResponse httpResponse) throws IOException {
        return mapper
                .readTree(httpResponse.parseAsString())
                .get("itemListElement")
                .toPrettyString();
    }
}
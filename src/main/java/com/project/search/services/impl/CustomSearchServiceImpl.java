package com.project.search.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.services.customsearch.Customsearch;
import com.google.api.services.customsearch.Customsearch.Cse.List;
import com.google.api.services.customsearch.model.Search;
import com.project.search.services.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
@Qualifier("CustomSearch")
public class CustomSearchServiceImpl implements SearchService {

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private Customsearch customsearch;

    @Value("${custom.search.engine}")
    private String searchEngine;

    @Override
    public String searchByKeyword(String keyword) {
        try {
            List list = buildRequest(keyword);
            Search result = list.execute();

            return mapper
                    .readTree(result.toString())
                    .toPrettyString();
        } catch (IOException exception) {
            log.error("Can't find such information!", exception);
            return "Can't find such information!";
        }
    }

    private List buildRequest(String keyword) throws IOException {
        return customsearch
                .cse()
                .list(keyword)
                .setCx(searchEngine);
    }
}

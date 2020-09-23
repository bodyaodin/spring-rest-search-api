package com.project.search.services.impl;

import com.project.search.convertors.HtmlToPlainText;
import com.project.search.services.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
@Qualifier("WikiSearch")
public class WikipediaSearchServiceImpl implements SearchService {

    @Autowired
    private HtmlToPlainText htmlToPlainText;

    @Value("${wikipedia.url}")
    private String url;

    @Override
    public String searchByKeyword(String keyword) {
        String searchUrl = url + keyword;

        try {
            String html = Jsoup
                    .connect(searchUrl)
                    .execute()
                    .body();

            Element body = Jsoup
                    .parseBodyFragment(html)
                    .body();

            Elements tables = body
                    .getElementsByTag("table");

            for (Element table : tables) {
                if (table.className().contains("infobox")) {
                    return htmlToPlainText.getPlainText(table);
                }
            }

            return "Can't find such information!";
        } catch (IOException exception) {
            log.error("Can't find such information!", exception);
            return "Can't find such information!";
        }
    }
}

package com.project.search.services;

public interface SearchWithParamService extends SearchService {

    String searchByKeywordAndParam(String keyword, String param);

}

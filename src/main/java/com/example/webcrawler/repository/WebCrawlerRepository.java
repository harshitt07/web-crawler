package com.example.webcrawler.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class WebCrawlerRepository {

    HashMap<String, List<String>> urls;

    public void save(String seedUrl, String url) {
        urls.computeIfAbsent("seedUrl", K -> new ArrayList<>()).add(url);
    }

    public List<String> getUrl(String seedUrl) {
        List<String> result = new ArrayList<>();
        if(urls.containsKey(seedUrl)) result = urls.get(seedUrl);
        return result;
    }

}

package com.example.webcrawler.service;

import com.example.webcrawler.repository.WebCrawlerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;

@Slf4j
@Service
@RequiredArgsConstructor
public class WebCrawlerService {

    private final WebCrawlerRepository webCrawlerRepository;
    private final HashSet<String> visitedUrls;

    public void crawl(String url, int depth) throws IOException {
        if(depth > 3) return ;
        Document document = (Document) Jsoup.connect(url).get();
        Elements links = document.select("a[href]");
        log.info("Crawling {} at depth {}", url, depth);
        visitedUrls.add(url);
        for (Element link : links) {
            String absoluteUrl = link.absUrl("href");
            if(!visitedUrls.contains(absoluteUrl)) crawl(absoluteUrl, depth + 1);
        }
        webCrawlerRepository.save(url, "aaa");
    }

}

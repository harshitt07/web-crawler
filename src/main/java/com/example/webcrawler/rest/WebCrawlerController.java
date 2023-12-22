package com.example.webcrawler.rest;

import jakarta.websocket.server.PathParam;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import com.example.webcrawler.service.WebCrawlerService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Component
@RestController
@RequiredArgsConstructor
@RequestMapping("/crawl")
public class WebCrawlerController {

    private final WebCrawlerService webCrawlerService;

    @GetMapping
    public void getCrawl(@RequestParam("seedUrl") String seedUrl) throws IOException {
        webCrawlerService.crawl(seedUrl, 0);
    }

}

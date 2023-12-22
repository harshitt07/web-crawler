package com.example.webcrawler;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebcrawlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebcrawlerApplication.class, args);
	}

}

/**
 *
 * -----> seedUrl, newResultFlag, depth -----> crawl -----> uniqueToken
 * -----> uniqueToken -----> results ----> whatever list of URLs we have, status: FINISHED, IN_PROGRESS
 *  we can implement the concept of Thread
 *  caching a results if request is fetched again
 *  deeper the graph then the process can go for days, level wise crawling
 *
 * */
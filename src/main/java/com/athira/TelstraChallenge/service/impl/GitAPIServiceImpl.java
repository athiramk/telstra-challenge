package com.athira.TelstraChallenge.service.impl;


import com.athira.TelstraChallenge.dto.GithubSearchResponse;
import com.athira.TelstraChallenge.service.GitAPIService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Slf4j
@Service
public class GitAPIServiceImpl implements GitAPIService {
    private final RestClient restClient;


    public GitAPIServiceImpl() {
        log.info("Initializing GitAPIServiceImpl with RestClient");

        this.restClient = RestClient.builder()
                .baseUrl("https://api.github.com")
                .defaultHeader("Accept", "application/vnd.github.preview")
                .build();
    }

    public GithubSearchResponse getOldestZeroFollowers(int count) {

        log.info("Fetching oldest users with zero followers, count:"+ count);

        if(count==0) {
            log.warn("Count is zero, returning empty response");
            return new GithubSearchResponse(0, List.of());
        }

        return restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/search/users")
                        .queryParam("q", "followers:0")
                        .queryParam("sort", "joined")
                        .queryParam("order", "asc")
                        .queryParam("per_page", count) // Tell GitHub to only return 'count' items
                        .build())
                .retrieve()
                .body(GithubSearchResponse.class);
    }
}

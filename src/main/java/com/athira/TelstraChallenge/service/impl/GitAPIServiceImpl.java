package com.athira.TelstraChallenge.service.impl;


import com.athira.TelstraChallenge.dto.GithubSearchResponse;
import com.athira.TelstraChallenge.service.GitAPIService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class GitAPIServiceImpl implements GitAPIService {
    private final RestClient restClient;

    public GitAPIServiceImpl() {
        this.restClient = RestClient.builder()
                .baseUrl("https://api.github.com")
                .defaultHeader("Accept", "application/vnd.github.preview")
                .build();
    }

    public GithubSearchResponse getOldestZeroFollowers(int count) {
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

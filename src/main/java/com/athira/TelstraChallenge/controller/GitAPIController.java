package com.athira.TelstraChallenge.controller;

import com.athira.TelstraChallenge.dto.GithubSearchResponse;
import com.athira.TelstraChallenge.service.GitAPIService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/git")
public class GitAPIController {
    private final GitAPIService gitAPIService;

    public GitAPIController(GitAPIService gitAPIService) {
        this.gitAPIService = gitAPIService;
    }

    @GetMapping("/search")
    public GithubSearchResponse searchOldestZeroFollowers(@RequestParam(name = "count", defaultValue = "3") int count) {
        log.info("Received request to search for oldest users with zero followers, count: "+ count);
        return gitAPIService.getOldestZeroFollowers(count);
    }
}

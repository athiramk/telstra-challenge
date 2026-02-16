package com.athira.TelstraChallenge.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class GitAPIConfig {

    public RestClient restClient(RestClient.Builder builder) {
        return builder.baseUrl("https://api.github.com/search/users").build();
    }
}

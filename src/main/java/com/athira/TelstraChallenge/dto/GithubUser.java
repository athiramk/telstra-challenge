package com.athira.TelstraChallenge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record GithubUser( // Must be public
      Long id,
      String login,
      @JsonProperty("html_url") String htmlUrl
) {}
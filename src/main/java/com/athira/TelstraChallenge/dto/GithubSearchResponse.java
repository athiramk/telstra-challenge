package com.athira.TelstraChallenge.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record GithubSearchResponse( // Must be public
                                    @JsonProperty("total_count") int totalCount,
                                    List<GithubUser> items
) {}
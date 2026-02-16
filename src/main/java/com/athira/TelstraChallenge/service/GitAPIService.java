package com.athira.TelstraChallenge.service;
import com.athira.TelstraChallenge.dto.GithubSearchResponse;

import java.util.List;

public interface GitAPIService {

    GithubSearchResponse getOldestZeroFollowers(int count);
}

package com.levelup.service;

import com.levelup.model.GithubCredentials;
import com.levelup.model.GithubRepositoryDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service("singleTransactionsService")
public class RepositoriesService {

    private final String REST_API = "https://api.github.com/";

    public GithubRepositoryDetails getRepository(GithubCredentials githubCredentials) {

        StringBuilder url = new StringBuilder()
                .append(REST_API)
                .append("repos/")
                .append(githubCredentials.getOwner() + "/")
                .append(githubCredentials.getRepositoryName());

        List<GithubRepositoryDetails> githubRepositoryDetails = Arrays.asList(new RestTemplate().getForObject(url.toString(), GithubRepositoryDetails.class));

        GithubRepositoryDetails githubRepositoryDetails1 = new GithubRepositoryDetails("x","x","x","x","x");

        return githubRepositoryDetails1;
    }
}
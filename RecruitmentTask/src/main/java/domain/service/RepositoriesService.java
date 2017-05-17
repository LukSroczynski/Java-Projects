package domain.service;

import domain.model.GithubCredentials;
import domain.model.GithubRepositoryDetails;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Lukasz S. on 09.05.2017.
 */

@Service
public class RepositoriesService {

    private final String REST_API = "https://api.github.com/";
    private final String REPOS = "repos/";

    public GithubRepositoryDetails getRepository(GithubCredentials githubCredentials) {

        StringBuilder url = new StringBuilder()
                .append(REST_API)
                .append(REPOS)
                .append(githubCredentials.getOwner() + "/")
                .append(githubCredentials.getRepositoryName());

        return new RestTemplate().getForObject(url.toString(), GithubRepositoryDetails.class);
    }
}
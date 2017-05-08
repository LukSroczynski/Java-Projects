package domain.service;

import domain.model.GithubRepositoryDetails;
import domain.model.GithubCredentials;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class RepositoriesService {

    private final String REST_API = "https://api.github.com/";

    public List<GithubRepositoryDetails> getRepository(GithubCredentials githubCredentials) {

        StringBuilder url = new StringBuilder()
                .append(REST_API)
                .append("repos/")
                .append(githubCredentials.getOwner() + "/")
                .append(githubCredentials.getRepositoryName());

        List<GithubRepositoryDetails> githubRepositoryDetails = Arrays.asList(new RestTemplate().getForObject(url.toString(), GithubRepositoryDetails.class));

        return githubRepositoryDetails;
    }
}
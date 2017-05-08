package domain.entities;

import domain.UserRepositoryModel;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class RepositoriesService {

    private final String REST_API = "https://api.github.com/";

    public List<GithubRepositoryDetails> getRepository(UserRepositoryModel userRepositoryModel) {

        StringBuilder url = new StringBuilder()
                .append(REST_API)
                .append("repos/")
                .append(userRepositoryModel.getOwner() + "/")
                .append(userRepositoryModel.getRepositoryName());

        List<GithubRepositoryDetails> quotes = Arrays.asList(new RestTemplate().getForObject(url.toString(), GithubRepositoryDetails.class));

        return quotes;
    }
}
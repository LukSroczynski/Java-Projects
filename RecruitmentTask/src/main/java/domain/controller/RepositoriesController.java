package domain.controller;

import domain.model.GithubCredentials;
import domain.model.GithubRepositoryDetails;
import domain.service.RepositoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RepositoriesController {

    @Autowired
    private RepositoriesService repositoriesService;

    private GithubCredentials githubCredentials;

    @RequestMapping(value = "/repositories/{owner}/{repository-name}", method = RequestMethod.GET)
    public List<GithubRepositoryDetails> getAllConfigurations(
            @PathVariable String owner,
            @PathVariable(name = "repository-name") String repositoryName){

        githubCredentials = new GithubCredentials(owner, repositoryName);

        return repositoriesService.getRepository(githubCredentials);
    }
}
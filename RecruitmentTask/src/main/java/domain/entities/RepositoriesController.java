package domain.entities;

import domain.UserRepositoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RepositoriesController {

    @Autowired
    private RepositoriesService repositoriesService;

    private UserRepositoryModel userRepositoryModel;

    @RequestMapping(value = "/repositories/{owner}/{repository-name}", method = RequestMethod.GET)
    public List<GithubRepositoryDetails> getAllConfigurations(
            @PathVariable String owner,
            @PathVariable(name = "repository-name") String repositoryName){

        userRepositoryModel = new UserRepositoryModel(owner, repositoryName);

        return repositoriesService.getRepository(userRepositoryModel);
    }
}
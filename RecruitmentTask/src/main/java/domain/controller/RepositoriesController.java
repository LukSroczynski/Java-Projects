package domain.controller;

import domain.model.GithubCredentials;
import domain.model.GithubRepositoryDetails;
import domain.service.RepositoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Lukasz S. on 09.05.2017.
 */

@RestController
public class RepositoriesController {

	@Autowired
	private RepositoriesService repositoriesService;

	@RequestMapping(value = "/repositories/{owner}/{repository-name}", method = RequestMethod.GET)
	public GithubRepositoryDetails getRepositoryDetails(
			@PathVariable String owner,
			@PathVariable("repository-name") String repositoryName){

		return repositoriesService.getRepository(new GithubCredentials(owner, repositoryName));
	}
}

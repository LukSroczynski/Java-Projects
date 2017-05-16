package domain.controller;

import domain.model.GithubCredentials;
import domain.model.GithubRepositoryDetails;
import domain.service.RepositoriesService;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;


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
			@PathVariable("repository-name") String repositoryName) throws InterruptedException {

        return repositoriesService.getRepository(new GithubCredentials(owner, repositoryName));
	}
}

package com.levelup;

import com.levelup.model.GithubCredentials;
import com.levelup.model.GithubRepositoryDetails;
import com.levelup.service.RepositoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Resource(name = "singleTransactionsService")
public class AddressController {

	@Autowired
	private RepositoriesService repositoriesService;

	private GithubCredentials githubCredentials;

	@RequestMapping(value = "/repositories/{owner}/{repository-name}", method = RequestMethod.GET)
	public @ResponseBody
	GithubRepositoryDetails getAllConfigurations(
			@PathVariable String owner,
			@PathVariable(name = "repository-name") String repositoryName){

		githubCredentials = new GithubCredentials(owner, repositoryName);
		return repositoriesService.getRepository(githubCredentials);
	}
}

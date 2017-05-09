package com.levelup.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GithubRepositoryDetails {

    private String full_name;

    private String description;

    private String clone_url;

    private String stargazers_count;

    private String created_at;

}

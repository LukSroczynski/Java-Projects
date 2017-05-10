package domain.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

/**
 * Created by Lukasz S. on 09.05.2017.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GithubRepositoryDetails {

    private String full_name;

    private String description;

    private String clone_url;

    private String stargazers_count;

    @JsonFormat(pattern="yyyy-MM-dd")
    private Date created_at;
}

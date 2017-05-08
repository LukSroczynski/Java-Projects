package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Lukasz S. on 08.05.2017.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRepositoryModel {
    private String owner;
    private String repositoryName;
}

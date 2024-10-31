package cou.dev.gibackend.model.sto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author sparkle6979l
 * @version 1.0
 * @data 2024/10/31 15:05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSTO {
    private String login;

    private Long id;

    private String avatarUrl;

    private String htmlUrl;

    private String subscriptionsUrl;

    private String organizationsUrl;

    private String reposUrl;

    private String type;

    private String name;

    private String company;

    private String location;

    private String email;

    private Long followers;

    private Long following;

    private String createAt;

    private Long totalPrivateRepos;

    private Long ownedPrivateRepos;
}

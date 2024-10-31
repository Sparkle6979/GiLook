package cou.dev.gibackend.config;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author sparkle6979l
 * @version 1.0
 * @data 2024/10/31 18:14
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "github")
public class GitInterConfig {

    private String authToken;

    private String apiUrlGetUser;
}

package cou.dev.gibackend.util;

import cou.dev.gibackend.config.GitInterConfig;
import okhttp3.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author sparkle6979l
 * @version 1.0
 * @data 2024/10/31 15:57
 */
@Component
public class RequestUtils {
    private static String gitToken;

    @Autowired(required = false)
    @Value("${github.auth-token}")
    public void setGitToken(String token) {
        RequestUtils.gitToken = token;
    }

    public static Request.Builder getAuthRequestBuilder() {
        return getAuthRequestBuilder(gitToken);
    }

    private static Request.Builder getAuthRequestBuilder(String token) {
        String authToken = "token " + token;
        return new Request.Builder()
                .addHeader("Authorization", authToken)
                .addHeader("Accept", "*/*")
                .addHeader("Host", "api.github.com")
                .addHeader("Connection", "Keep-Alive");
    }
}

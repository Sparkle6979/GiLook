package cou.dev.gibackend.interaction;

import com.alibaba.fastjson.JSONObject;
import cou.dev.gibackend.config.GitInterConfig;
import cou.dev.gibackend.model.sto.UserSTO;
import cou.dev.gibackend.util.RequestUtils;
import cou.dev.gibackend.util.UrlPathUtils;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.io.IOException;
import java.util.Optional;

/**
 * @author sparkle6979l
 * @version 1.0
 * @data 2024/10/31 14:52
 */
@Slf4j
@Component
public class UserInteractive {
    @Autowired
    private OkHttpClient httpClient;

    @Autowired
    private GitInterConfig gitInterConfig;

    public UserSTO getUserByName(String userName) {
        Request request = RequestUtils.getAuthRequestBuilder()
                .url(UrlPathUtils.concatGetPath(gitInterConfig.getApiUrlGetUser(), userName))
                .build();

        String responseBody = null;
        try (Response response = httpClient.newCall(request).execute()) {
            if (response.isSuccessful()) {
                responseBody = response.body() != null ? response.body().string() : null;
            } else {
                log.error(String.format("UserInteractive.getUserByName error, response = %s", response));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return JSONObject.parseObject(responseBody, UserSTO.class);
    }
}

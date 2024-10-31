package cou.dev.gibackend.config;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @author sparkle6979l
 * @version 1.0
 * @data 2024/10/31 14:56
 */
@Configuration
public class OkhttpConfig {
    @Bean
    public OkHttpClient getOkHttpClient(){
        return new OkHttpClient().newBuilder()
                .connectTimeout(180, TimeUnit.SECONDS)
                .readTimeout(180, TimeUnit.SECONDS)
                .writeTimeout(180, TimeUnit.SECONDS)
                .build();
    }

}

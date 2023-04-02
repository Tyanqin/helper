package com.zxt.helper.config;

import io.minio.MinioClient;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author:TanXiao
 * @date:2023/3/29
 */

@Data
@Configuration
@Component
//@PropertySource(value = {"classpath:application.yml"},
//        ignoreResourceNotFound = false, encoding = "UTF-8", name = "authorSetting.properties")
@ConfigurationProperties(value = "minio")
public class MinioConfig {

    @Value("${minio.url}")
    private String url;

    @Value("${minio.access-key}")
    private String accessKey;

    @Value("${minio.secret-key}")
    private String secretKey;

    @Value("${minio.bucket-name}")
    private String bucketName;

    @Bean
    public MinioClient minioClient() {
        MinioClient minioClient =  MinioClient.builder()
                .endpoint("127.0.0.1",9000,false)
                .credentials("minioadmin", "minioadmin")
                .build();
        return minioClient;
    }
}

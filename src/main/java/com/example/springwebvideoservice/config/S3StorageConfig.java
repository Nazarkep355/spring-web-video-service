package com.example.springwebvideoservice.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class S3StorageConfig {

    private final String ACCESS_KEY="AKIAUAKTT25XBHSVRYMD";
    private final String SECRET_KEY="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";
    private final String region = "eu-north-1";
    @Bean
    public AmazonS3 amazonS3(){
        AWSCredentials credentials = new BasicAWSCredentials(ACCESS_KEY,SECRET_KEY);
        return AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(region)
                .build();
    }
}

package com.example.springwebvideoservice.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.S3Resource;
import com.amazonaws.services.s3.model.S3Object;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.io.File;

@Service
@RequiredArgsConstructor
public class AWSStreamingService {
    @Value("${bucket-name}")
    private  String bucketName;
    private final AmazonS3 s3Client;
    private final ResourceLoader resourceLoader;
    public Mono<Resource> getResource(String name) {
        S3Object s3Object =s3Client.getObject(bucketName,name);
       return Mono
               .fromSupplier(()->resourceLoader
                       .getResource(s3Object.getRedirectLocation()));
    }

}

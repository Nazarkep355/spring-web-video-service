package com.example.springwebvideoservice.controller;

import com.example.springwebvideoservice.service.UploadS3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class UploadController {
    private final UploadS3Service s3Service;
    @PostMapping("/api/upload")
    public ResponseEntity<String> uploadFile(MultipartFile file){
        return ResponseEntity.ok(s3Service.uploadFile(file) );
    }
}

package com.example.springwebvideoservice.controller;

import com.example.springwebvideoservice.service.AWSStreamingService;
import com.example.springwebvideoservice.service.UploadS3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class UploadController {
    private final UploadS3Service s3Service;
    private final AWSStreamingService streamingService;
    @PostMapping("/api/upload")
    public ResponseEntity<String> uploadFile(MultipartFile file){
        return ResponseEntity.ok(s3Service.uploadFile(file));
    }
    @GetMapping("/video")
    public Mono<Resource> getVideo(){
        return streamingService.getResource("1708432391949_Jujutsu_Kaisen_[01]_[AniLibria_TV]_[WEBRip_1080p_HEVC].mkv");
    }
}

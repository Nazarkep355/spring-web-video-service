package com.example.springwebvideoservice.controller;

import com.example.springwebvideoservice.entity.Episode;
import com.example.springwebvideoservice.model.EpisodeModel;
import com.example.springwebvideoservice.service.EpisodeManagementService;
import com.example.springwebvideoservice.service.ModelMapperService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Slf4j
@RequiredArgsConstructor
public class EpisodeUploadController {
    private final EpisodeManagementService episodeManagementService;
    final ModelMapperService mapperService;

    @PostMapping("/api/episodes/add")
    public ResponseEntity<EpisodeModel> saveNewEpisode(HttpServletRequest request, MultipartFile file) {
        Episode episode = episodeManagementService.ParseRequest(request);
        Episode savedEpisode = episodeManagementService.saveNewEpisode(episode, file);
        return ResponseEntity.ok(mapperService.mapObject(savedEpisode, EpisodeModel.class));
    }
}

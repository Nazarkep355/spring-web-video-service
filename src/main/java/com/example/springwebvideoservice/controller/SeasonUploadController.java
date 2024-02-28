package com.example.springwebvideoservice.controller;

import com.example.springwebvideoservice.entity.Season;
import com.example.springwebvideoservice.model.SeasonModel;
import com.example.springwebvideoservice.service.ModelMapperService;
import com.example.springwebvideoservice.service.SeasonManagementService;
import jakarta.annotation.Nullable;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/seasons/add")
public class SeasonUploadController {
    final ModelMapperService mapperService;
    final SeasonManagementService seasonService;

    @PostMapping
    public ResponseEntity<SeasonModel> addNewSeason(HttpServletRequest request, MultipartFile file) {
        Season season = seasonService.parseRequest(request);
        Season savedSeason = seasonService.saveNewSeason(season, file);
        return ResponseEntity.ok(mapperService.mapObject(savedSeason, SeasonModel.class));
    }

}

package com.example.springwebvideoservice.controller;

import com.example.springwebvideoservice.model.SeasonModel;
import com.example.springwebvideoservice.service.SeasonListService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/seasons")
public class ShowListController {
    private final SeasonListService service;
    @GetMapping("/latest")
    public ResponseEntity<List<SeasonModel>> getLatestSeasons(Pageable pageable){
        return ResponseEntity.ok(service.getLatestSeasons(pageable));
    }
}

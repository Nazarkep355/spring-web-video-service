package com.example.springwebvideoservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class EpisodeModel {
    private Long id;
    private String name;
    private String source;
    private LocalDateTime uploadDate;

}

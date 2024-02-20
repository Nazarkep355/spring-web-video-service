package com.example.springwebvideoservice.model;

import com.example.springwebvideoservice.entity.Season;
import com.fasterxml.jackson.databind.cfg.MapperBuilder;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class SeasonModel {
    private Long id;
    private String name;
    private double rating;
    private LocalDateTime releaseDate;
    private String poster;
}

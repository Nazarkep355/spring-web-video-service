package com.example.springwebvideoservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@Entity
@Table
@AllArgsConstructor
@RequiredArgsConstructor
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    @ManyToOne
    private Show show;
    private int numberOfEpisodes;
    private LocalDateTime releaseDate;
    @OneToMany
    private List<Episode> episodes;
    private double rating;
    @OneToMany
    private List<Comment> comments;
}

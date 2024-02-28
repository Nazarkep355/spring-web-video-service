package com.example.springwebvideoservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@Entity
@Table
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    @NonNull
    @ManyToOne
    private Show show;
    private int numberOfEpisodes;
    private LocalDateTime releaseDate;
    @OneToMany
    private List<Episode> episodes;
    private double rating;
    @OneToMany
    private List<Comment> comments;
    private String poster;
}

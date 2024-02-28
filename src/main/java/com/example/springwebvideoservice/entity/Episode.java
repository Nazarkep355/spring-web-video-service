package com.example.springwebvideoservice.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "episodes")
@Builder
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String source;
    @NonNull
    @ManyToOne
    private Season season;
    private LocalDateTime uploadDate;

}

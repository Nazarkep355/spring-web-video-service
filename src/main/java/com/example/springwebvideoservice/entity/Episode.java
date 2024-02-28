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
@NoArgsConstructor
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String source;
    private int index;
    @NonNull
    @ManyToOne
    private Season season;
    private LocalDateTime uploadDate;

}

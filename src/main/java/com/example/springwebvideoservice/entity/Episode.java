package com.example.springwebvideoservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
@Entity
@Table(name = "episodes")
@Builder
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Episode {
    @Id
    private Long id;
    private String name;
    private String source;
    @ManyToOne
    private Season season;
    private LocalDateTime uploadDate;

}

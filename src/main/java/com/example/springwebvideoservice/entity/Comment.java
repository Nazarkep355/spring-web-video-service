package com.example.springwebvideoservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class Comment {
    @Id
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Season season;
    private String text;
    private LocalDateTime uploadTime;
}

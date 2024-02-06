package com.example.springwebvideoservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@Entity
@Table
@AllArgsConstructor
@RequiredArgsConstructor
public class Season {
    @Id
    private Long id;
    private String name;
    @ManyToOne
    private Show show;
    private int numberOfEpisodes;

}

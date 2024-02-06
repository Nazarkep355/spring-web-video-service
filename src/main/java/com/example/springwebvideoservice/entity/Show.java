package com.example.springwebvideoservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Data
@Entity
@Table(name = "shows")
@Builder
@Slf4j
@AllArgsConstructor
@RequiredArgsConstructor

public class Show {
    @Id
    private Long id;
    private String name;
    @OneToMany(mappedBy = "show")
    private List<Season> seasons;
    private String description;

}

package com.example.springwebvideoservice.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Data
@Entity
@Table(name = "shows")
@Builder
@Slf4j
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NonNull
    private String name;
    @OneToMany(mappedBy = "show")
    private List<Season> seasons;
    private String description;

}

package com.example.springwebvideoservice.repo;


import com.example.springwebvideoservice.entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface EpisodeRepository extends JpaRepository<Episode, Long> {
}

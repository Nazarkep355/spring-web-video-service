package com.example.springwebvideoservice.repo;

import com.example.springwebvideoservice.entity.Season;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Transactional
@Repository
public interface SeasonRepository extends JpaRepository<Season, Long> {
    @Query("select s from Season s order by releaseDate desc")
    List<Season> findAllOrderByReleaseDateDesc(Pageable pageable);
    Optional<Season> findById(Long id);
    Optional<Season> findByName(String name);
}

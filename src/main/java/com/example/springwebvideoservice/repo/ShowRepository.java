package com.example.springwebvideoservice.repo;

import com.example.springwebvideoservice.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Transactional
@Repository
public interface ShowRepository extends JpaRepository<Show, Long> {
    Optional<Show> findByName(String name);

    List<Show> findByNameContains(String name);
}

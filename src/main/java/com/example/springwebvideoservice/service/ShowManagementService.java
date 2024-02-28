package com.example.springwebvideoservice.service;

import com.example.springwebvideoservice.entity.Show;
import com.example.springwebvideoservice.repo.ShowRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ShowManagementService {
    private final ShowRepository showRepository;


    public boolean isShowExists(String name) {
        Optional<Show> showOptional = showRepository.findByName(name);
        return showOptional.isPresent();
    }

    public List<Show> findByPartName(String name) {
        return showRepository.findByNameContains(name);
    }

    public Show findById(Long id) {
        return showRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Show not found"));
    }

    public Show saveNewShow(String name, String description){
        if(isShowExists(name))
            throw new IllegalArgumentException("Show exists");
        Show show = Show.builder()
                .name(name)
                .description(description)
                .build();
        return showRepository.save(show);
    }
}

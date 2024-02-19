package com.example.springwebvideoservice.service;

import com.example.springwebvideoservice.entity.Season;
import com.example.springwebvideoservice.model.SeasonModel;
import com.example.springwebvideoservice.repo.SeasonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SeasonListService {
    private final SeasonRepository seasonRepository;
    private final ModelMapperService mapperService;

    public List<SeasonModel> getLatestSeasons(Pageable pageable) {
        pageable = removeSort(pageable);
        List seasons = seasonRepository.findAllOrderByReleaseDateDesc(pageable);
        seasons = seasons.stream()
                .map(object ->
                        mapperService.mapObject(object, SeasonModel.class)
                )
                .toList();
        return seasons;
    }


    private Pageable removeSort(Pageable pageable) {
        int size = Integer.min(pageable.getPageSize(), 20);
        return PageRequest.of(pageable.getPageNumber(), size);
    }
}

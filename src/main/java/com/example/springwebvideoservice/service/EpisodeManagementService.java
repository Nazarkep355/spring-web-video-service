package com.example.springwebvideoservice.service;

import com.amazonaws.services.s3.model.S3Object;
import com.example.springwebvideoservice.entity.Episode;
import com.example.springwebvideoservice.entity.Season;
import com.example.springwebvideoservice.model.EpisodeModel;
import com.example.springwebvideoservice.repo.EpisodeRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class EpisodeManagementService {
    private final EpisodeRepository episodeRepository;
    private final UploadS3Service s3Service;
    private final SeasonManagementService seasonService;
    private final ModelMapperService mapperService;

    public Episode ParseRequest(HttpServletRequest request) {
        String seasonIdParam = request.getParameter("season-id");
        String indexParam = request.getParameter("index");
        Long seasonId = null;
        Integer index = null;
        try {
            seasonId = Long.parseLong(seasonIdParam);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Season not found");
        }
        try {
            index = Integer.parseInt(indexParam);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Index wrong");
        }
        Season season = seasonService.findById(seasonId);
        return Episode.builder()
                .name(request.getParameter("name"))
                .index(index)
                .season(season)
                .build();
    }

    @Transactional
    public Episode saveNewEpisode(Episode episode, MultipartFile file) {
        if (episode.getSeason().getEpisodes()
                .stream()
                .anyMatch(obj -> episode.getIndex() == obj.getIndex())) {
            throw new IllegalArgumentException("Wrong index");
        }


        String fileName = s3Service.uploadFile(file);
        episode.setSource(fileName);
        episode.setUploadDate(LocalDateTime.now());
        return episodeRepository.save(episode);

    }
}

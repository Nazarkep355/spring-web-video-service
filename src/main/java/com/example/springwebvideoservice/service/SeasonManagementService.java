package com.example.springwebvideoservice.service;

import com.example.springwebvideoservice.entity.Season;
import com.example.springwebvideoservice.entity.Show;
import com.example.springwebvideoservice.repo.SeasonRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class SeasonManagementService {
    private final ShowManagementService showService;
    private final SeasonRepository seasonRepository;
    private final UploadS3Service s3Service;

    public boolean isSeasonExists(String name) {
        Optional<Season> season = seasonRepository.findByName(name);
        return season.isPresent();
    }

    public Season findById(Long id) {
        return seasonRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Season not found"));
    }

    @Transactional
    public Season saveNewSeason(Season season, MultipartFile file) {
        if (isSeasonExists(season.getName()))
            throw new IllegalArgumentException("Season exists");
        if (!showService.isShowExists(season.getShow().getName())
                && season.getShow().getId() == null) {
            season.setShow(showService.saveNewShow(season.getShow().getName(),
                    season.getShow().getDescription()));
        }
        season.setShow(showService.findById(season.getShow().getId()));
        String poster = s3Service.uploadFile(file);
        season.setPoster(poster);
        return seasonRepository.save(season);
    }

    public Season parseRequest(HttpServletRequest request) {
        Long showid;
        String showName = request.getParameter("show");
        String seasonName = request.getParameter("name");
        String description = request.getParameter("description");
        LocalDateTime releaseDate = LocalDateTime
                .parse(request.getParameter("release-date"));
        if (request.getParameter("showid").isEmpty()) {
            showid = null;
        } else {
            showid = Long.parseLong(request.getParameter("showid"));
        }

        Show show = Show.builder()
                .name(showName)
                .description(description)
                .id(showid)
                .build();
        return Season.builder()
                .releaseDate(releaseDate)
                .show(show)
                .name(seasonName)
                .build();
    }


}

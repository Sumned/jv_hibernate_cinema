package com.dev.cinema.controller.cinemahall;

import com.dev.cinema.mapper.CinemaHallMapper;
import com.dev.cinema.model.dto.cinemahall.CinemaHallRequestDto;
import com.dev.cinema.model.dto.cinemahall.CinemaHallResponseDto;
import com.dev.cinema.service.CinemaHallService;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/halls")
public class CinemaHallController {
    private static final Logger LOGGER =
            LogManager.getLogger(CinemaHallController.class);
    private CinemaHallMapper cinemaHallMapper;
    private CinemaHallService cinemaHallService;

    public CinemaHallController(CinemaHallMapper cinemaHallMapper,
                                CinemaHallService cinemaHallService) {
        this.cinemaHallMapper = cinemaHallMapper;
        this.cinemaHallService = cinemaHallService;
    }

    @PostMapping
    public String addHall(@RequestBody CinemaHallRequestDto requestDto) {
        LOGGER.info(requestDto.toString());
        cinemaHallService.add(cinemaHallMapper.getCinemaHallFromRequestDto(requestDto));
        return "Hall added";
    }

    @GetMapping
    public List<CinemaHallResponseDto> getAll() {
        return cinemaHallService.getAll().stream()
                .map(cinemaHall -> cinemaHallMapper.getCinemaHallResponseDto(cinemaHall))
                .collect(Collectors.toList());
    }
}

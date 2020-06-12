package com.dev.cinema.mapper;

import com.dev.cinema.model.CinemaHall;
import com.dev.cinema.model.dto.cinemahall.CinemaHallRequestDto;
import com.dev.cinema.model.dto.cinemahall.CinemaHallResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallMapper {
    public CinemaHall getCinemaHallFromRequestDto(CinemaHallRequestDto requestDto) {
        return new CinemaHall(requestDto.getCapacity(), requestDto.getDescription());
    }

    public CinemaHallResponseDto getCinemaHallResponseDto(CinemaHall cinemaHall) {
        return new CinemaHallResponseDto(cinemaHall.getId(), cinemaHall.getDescription());
    }
}

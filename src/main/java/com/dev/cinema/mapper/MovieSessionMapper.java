package com.dev.cinema.mapper;

import com.dev.cinema.model.MovieSession;
import com.dev.cinema.model.dto.moviesession.MovieSessionRequestDto;
import com.dev.cinema.model.dto.moviesession.MovieSessionResponseDto;
import com.dev.cinema.service.CinemaHallService;
import com.dev.cinema.service.MovieService;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapper {
    private MovieService movie;
    private CinemaHallService cinemaHall;
    private MovieMapper movieMapper;
    private CinemaHallMapper cinemaHallMapper;

    public MovieSession getMovieSessionFromRequestDto(MovieSessionRequestDto requestDto) {
        MovieSession movieSession = new MovieSession();
        //movieSession.setShowTime(requestDto.getShowTime());
        movieSession.setCinemaHall(cinemaHall.getById(requestDto.getHallId()));
        movieSession.setMovie(movie.getById(requestDto.getMovieId()));
        return movieSession;
    }

    public MovieSessionResponseDto getMovieSessionResponseDto(MovieSession movieSession) {
        MovieSessionResponseDto responseDto = new MovieSessionResponseDto();
        responseDto.setId(movieSession.getId());
        responseDto.setShowTime(movieSession.getShowTime());
        responseDto.setMovie(movieMapper.getMovieResponseDto(movieSession.getMovie()));
        responseDto.setCinemaHall(cinemaHallMapper
                .getCinemaHallResponseDto(movieSession.getCinemaHall()));
        return responseDto;
    }
}

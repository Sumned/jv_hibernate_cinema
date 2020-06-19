package com.dev.cinema.mapper;

import com.dev.cinema.model.MovieSession;
import com.dev.cinema.model.dto.moviesession.MovieSessionRequestDto;
import com.dev.cinema.model.dto.moviesession.MovieSessionResponseDto;
import com.dev.cinema.service.CinemaHallService;
import com.dev.cinema.service.MovieService;
import java.time.LocalDateTime;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionMapper {
    private static final Logger LOGGER =
            LogManager.getLogger(MovieSessionMapper.class);
    private final MovieService movie;
    private final CinemaHallService cinemaHall;
    private final MovieMapper movieMapper;
    private final CinemaHallMapper cinemaHallMapper;

    public MovieSessionMapper(MovieService movie,
                              CinemaHallService cinemaHall,
                              MovieMapper movieMapper,
                              CinemaHallMapper cinemaHallMapper) {
        this.movie = movie;
        this.cinemaHall = cinemaHall;
        this.movieMapper = movieMapper;
        this.cinemaHallMapper = cinemaHallMapper;
    }

    public MovieSession getMovieSessionFromRequestDto(MovieSessionRequestDto requestDto) {
        LOGGER.info("MovieSession mapping started");
        MovieSession movieSession = new MovieSession();
        movieSession.setShowTime(LocalDateTime.parse(requestDto.getShowTime()));
        movieSession.setCinemaHall(cinemaHall.getById(requestDto.getHallId()));
        movieSession.setMovie(movie.getById(requestDto.getMovieId()));
        LOGGER.info(movieSession.toString());
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

package com.dev.cinema.mapper;

import com.dev.cinema.model.Movie;
import com.dev.cinema.model.dto.movie.MovieRequestDto;
import com.dev.cinema.model.dto.movie.MovieResponseDto;
import org.springframework.stereotype.Component;

@Component
public class MovieMapper {
    public Movie getMovieFromRequestDto(MovieRequestDto requestDto) {
        return new Movie(requestDto.getTitle(), requestDto.getDescription());
    }

    public MovieResponseDto getMovieResponseDto(Movie movie) {
        return new MovieResponseDto(movie.getId(), movie.getTitle());
    }
}

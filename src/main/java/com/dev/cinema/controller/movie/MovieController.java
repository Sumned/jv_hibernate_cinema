package com.dev.cinema.controller.movie;

import com.dev.cinema.mapper.MovieMapper;
import com.dev.cinema.model.dto.movie.MovieRequestDto;
import com.dev.cinema.model.dto.movie.MovieResponseDto;
import com.dev.cinema.service.MovieService;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {
    private final MovieMapper movieMapper;
    private final MovieService movieService;

    public MovieController(MovieMapper movieMapper, MovieService movieService) {
        this.movieMapper = movieMapper;
        this.movieService = movieService;
    }

    @PostMapping
    public String addMovie(@RequestBody @Valid MovieRequestDto requestDto) {
        movieService.add(movieMapper.getMovieFromRequestDto(requestDto));
        return "Movie added";
    }

    @GetMapping
    public List<MovieResponseDto> getAll() {
        return movieService.getAll().stream()
                .map(movieMapper::getMovieResponseDto)
                .collect(Collectors.toList());
    }
}

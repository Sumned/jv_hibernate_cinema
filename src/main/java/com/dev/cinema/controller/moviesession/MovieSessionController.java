package com.dev.cinema.controller.moviesession;

import com.dev.cinema.mapper.MovieSessionMapper;
import com.dev.cinema.model.dto.moviesession.MovieSessionRequestDto;
import com.dev.cinema.model.dto.moviesession.MovieSessionResponseDto;
import com.dev.cinema.service.MovieSessionService;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value = "/movie-sessions")
public class MovieSessionController {
    private static final Logger LOGGER =
            LogManager.getLogger(MovieSessionController.class);
    MovieSessionMapper movieSessionMapper;
    MovieSessionService movieSessionService;

    @GetMapping
    public ModelAndView movieSessions() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("movie/movie-sessions");
        return modelAndView;
    }

    @PostMapping
    public String addSession(@RequestBody @Valid MovieSessionRequestDto requestDto) {
        LOGGER.info(requestDto.toString());
        movieSessionMapper.getMovieSessionFromRequestDto(requestDto);
        return "Movie session added";
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    @GetMapping(value = "/available")
    public List<MovieSessionResponseDto> getAvailableSession(@RequestParam Long movieId,
                                                             @RequestParam LocalDate date) {
        return movieSessionService.findAvailableSessions(movieId, date)
                .stream().map(movieSession -> movieSessionMapper
                        .getMovieSessionResponseDto(movieSession))
                .collect(Collectors.toList());
    }
}

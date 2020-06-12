package com.dev.cinema.model.dto.moviesession;

import com.dev.cinema.model.dto.cinemahall.CinemaHallResponseDto;
import com.dev.cinema.model.dto.movie.MovieResponseDto;
import java.time.LocalDateTime;

public class MovieSessionResponseDto {
    private Long id;
    private LocalDateTime showTime;
    private MovieResponseDto movie;
    private CinemaHallResponseDto cinemaHall;

    public MovieSessionResponseDto() {
    }

    public MovieSessionResponseDto(Long id, LocalDateTime showTime,
                                   MovieResponseDto movie, CinemaHallResponseDto cinemaHall) {
        this.id = id;
        this.showTime = showTime;
        this.movie = movie;
        this.cinemaHall = cinemaHall;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }

    public MovieResponseDto getMovie() {
        return movie;
    }

    public void setMovie(MovieResponseDto movie) {
        this.movie = movie;
    }

    public CinemaHallResponseDto getCinemaHall() {
        return cinemaHall;
    }

    public void setCinemaHall(CinemaHallResponseDto cinemaHall) {
        this.cinemaHall = cinemaHall;
    }
}

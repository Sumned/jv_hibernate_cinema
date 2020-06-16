package com.dev.cinema.model.dto.moviesession;

import java.time.LocalDateTime;
import javax.validation.constraints.PastOrPresent;

public class MovieSessionRequestDto {
    @PastOrPresent
    private LocalDateTime showTime;
    private Long movieId;
    private Long hallId;

    public MovieSessionRequestDto() {
    }

    public MovieSessionRequestDto(LocalDateTime showTime, Long movieId, Long hallId) {
        this.showTime = showTime;
        this.movieId = movieId;
        this.hallId = hallId;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Long getHallId() {
        return hallId;
    }

    public void setHallId(Long hallId) {
        this.hallId = hallId;
    }

    @Override
    public String toString() {
        return "MovieSessionRequestDto{" + "showTime="
                + showTime + ", movieId=" + movieId
                + ", hallId=" + hallId + '}';
    }
}

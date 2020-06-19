package com.dev.cinema.model.dto.moviesession;

public class MovieSessionRequestDto {
    private String showTime;
    private Long movieId;
    private Long hallId;

    public MovieSessionRequestDto() {
    }

    public MovieSessionRequestDto(String showTime, Long movieId, Long hallId) {
        this.showTime = showTime;
        this.movieId = movieId;
        this.hallId = hallId;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
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

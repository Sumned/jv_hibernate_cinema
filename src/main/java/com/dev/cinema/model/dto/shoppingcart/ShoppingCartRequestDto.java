package com.dev.cinema.model.dto.shoppingcart;

public class ShoppingCartRequestDto {
    private Long movieSessionId;
    private Long userId;

    public ShoppingCartRequestDto() {
    }

    public ShoppingCartRequestDto(Long movieSessionId, Long userId) {
        this.movieSessionId = movieSessionId;
        this.userId = userId;
    }

    public Long getMovieSessionId() {
        return movieSessionId;
    }

    public void setMovieSessionId(Long movieSessionId) {
        this.movieSessionId = movieSessionId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ShoppingCartRequestDto{" + "movieSessionId="
                + movieSessionId + ", userId=" + userId + '}';
    }
}

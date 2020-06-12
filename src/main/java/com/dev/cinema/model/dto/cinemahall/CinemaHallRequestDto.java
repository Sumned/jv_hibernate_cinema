package com.dev.cinema.model.dto.cinemahall;

public class CinemaHallRequestDto {
    private int capacity;
    private String description;

    public CinemaHallRequestDto() {
    }

    public CinemaHallRequestDto(int capacity, String description) {
        this.capacity = capacity;
        this.description = description;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CinemaHallRequestDto{" + "capacity="
                + capacity + ", description='"
                + description + '\'' + '}';
    }
}
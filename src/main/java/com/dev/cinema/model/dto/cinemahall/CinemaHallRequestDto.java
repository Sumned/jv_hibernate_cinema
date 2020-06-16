package com.dev.cinema.model.dto.cinemahall;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class CinemaHallRequestDto {
    @Positive
    @Size(min = 1, max = 100)
    private int capacity;

    @NotNull
    @Size(max = 256)
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

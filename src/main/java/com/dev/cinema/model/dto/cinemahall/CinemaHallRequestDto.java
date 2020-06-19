package com.dev.cinema.model.dto.cinemahall;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CinemaHallRequestDto {
    @Min(value = 10, message = "Minimal size is 10")
    @Max(value = 100, message = "Maximal size is 100")
    private Integer capacity;

    @NotNull
    @Size(max = 256)
    private String description;

    public CinemaHallRequestDto() {
    }

    public CinemaHallRequestDto(Integer capacity, String description) {
        this.capacity = capacity;
        this.description = description;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
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

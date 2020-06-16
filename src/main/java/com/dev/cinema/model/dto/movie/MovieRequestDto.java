package com.dev.cinema.model.dto.movie;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MovieRequestDto {
    @NotNull
    @Size(max = 256)
    private String title;

    @NotNull
    @Size(max = 256)
    private String description;

    public MovieRequestDto() {
    }

    public MovieRequestDto(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "MovieRequestDto{" + "title='"
                + title + '\'' + ", description='"
                + description + '\'' + '}';
    }
}

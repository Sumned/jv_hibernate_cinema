package com.dev.cinema;

import com.dev.cinema.lib.Injector;
import com.dev.cinema.model.Movie;
import com.dev.cinema.service.MovieService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    private static Injector injector = Injector.getInstance("com.dev.cinema");

    public static void main(String[] args) {
        LOGGER.info("test");
        MovieService movieService = (MovieService) injector.getInstance(MovieService.class);
        Movie movie = new Movie();
        movie.setTitle("Wzuk-wzuk");
        movie.setDescription("Vin Diesel become fatty");
        movieService.add(movie);
        movieService.getAll().forEach(System.out::println);
    }
}

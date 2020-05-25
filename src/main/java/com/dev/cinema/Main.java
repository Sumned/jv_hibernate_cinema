package com.dev.cinema;

import com.dev.cinema.exceptions.AuthenticationException;
import com.dev.cinema.lib.Injector;
import com.dev.cinema.model.CinemaHall;
import com.dev.cinema.model.Movie;
import com.dev.cinema.model.MovieSession;
import com.dev.cinema.model.User;
import com.dev.cinema.security.AuthenticationService;
import com.dev.cinema.service.CinemaHallService;
import com.dev.cinema.service.MovieService;
import com.dev.cinema.service.MovieSessionService;
import com.dev.cinema.service.UserService;
import com.dev.cinema.util.HashUtil;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    private static final Injector INJECTOR = Injector.getInstance("com.dev.cinema");

    public static void main(String[] args) throws AuthenticationException {
        LOGGER.info("test");
        MovieService movieService = (MovieService) INJECTOR.getInstance(MovieService.class);
        Movie movie = new Movie();
        movie.setTitle("Wzuk-wzuk");
        movie.setDescription("Vin Diesel become fatty");
        movieService.add(movie);
        movieService.getAll().forEach(System.out::println);

        CinemaHall firstHall = new CinemaHall();
        firstHall.setCapacity(150);
        firstHall.setDescription("first hall");
        CinemaHall secondHall = new CinemaHall();
        secondHall.setCapacity(200);
        secondHall.setDescription("second hall");

        CinemaHallService cinemaHallService =
                (CinemaHallService) INJECTOR.getInstance(CinemaHallService.class);

        cinemaHallService.add(firstHall);
        cinemaHallService.add(secondHall);
        cinemaHallService.getAll().forEach(System.out::println);

        MovieSession sessionOne = new MovieSession();
        sessionOne.setCinemaHall(firstHall);
        sessionOne.setMovie(movie);
        sessionOne.setShowTime(LocalDateTime.of(LocalDate.of(2020, 5, 20),
                LocalTime.of(12, 30)));
        MovieSession sessionTwo = new MovieSession();
        sessionTwo.setCinemaHall(secondHall);
        sessionTwo.setMovie(movie);
        sessionTwo.setShowTime(LocalDateTime.of(LocalDate.of(2020, 5, 21),
                LocalTime.of(13, 30)));
        MovieSessionService movieSessionService =
                (MovieSessionService) INJECTOR.getInstance(MovieSessionService.class);
        movieSessionService.add(sessionOne);
        movieSessionService.add(sessionTwo);
        List<MovieSession> sessions = movieSessionService.findAvailableSessions(movie.getId(),
                LocalDate.of(2020, 5, 22));
        sessions.forEach(System.out::println);
        User user = new User();
        user.setEmail("user@user.com");
        user.setName("user1");
        user.setSalt(HashUtil.getSalt());
        user.setPassword(HashUtil.hashPassword("1234", user.getSalt()));
        UserService userService = (UserService) INJECTOR.getInstance(UserService.class);
        userService.add(user);
        System.out.println(userService.findByEmail("user@user.com"));

        AuthenticationService authenticationService
                = (AuthenticationService) INJECTOR.getInstance(AuthenticationService.class);
        authenticationService.register("userFromService@user.com", "1234");
        System.out.println(authenticationService.login("userFromService@user.com", "1234"));

    }
}

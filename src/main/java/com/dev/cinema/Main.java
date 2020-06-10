package com.dev.cinema;

import com.dev.cinema.config.AppConfig;
import com.dev.cinema.exceptions.AuthenticationException;
import com.dev.cinema.model.CinemaHall;
import com.dev.cinema.model.Movie;
import com.dev.cinema.model.MovieSession;
import com.dev.cinema.model.ShoppingCart;
import com.dev.cinema.model.User;
import com.dev.cinema.security.AuthenticationService;
import com.dev.cinema.service.CinemaHallService;
import com.dev.cinema.service.MovieService;
import com.dev.cinema.service.MovieSessionService;
import com.dev.cinema.service.OrderService;
import com.dev.cinema.service.ShoppingCartService;
import com.dev.cinema.service.UserService;
import com.dev.cinema.util.HashUtil;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws AuthenticationException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        MovieService movieService = context.getBean(MovieService.class);
        Movie movie = new Movie();
        movie.setTitle("Wzuk-wzuk");
        movie.setDescription("Vin Diesel become fatty");
        movieService.add(movie);
        movieService.getAll().forEach(LOGGER::info);

        CinemaHall firstHall = new CinemaHall();
        firstHall.setCapacity(150);
        firstHall.setDescription("first hall");
        CinemaHall secondHall = new CinemaHall();
        secondHall.setCapacity(200);
        secondHall.setDescription("second hall");

        CinemaHallService cinemaHallService =
                context.getBean(CinemaHallService.class);

        cinemaHallService.add(firstHall);
        cinemaHallService.add(secondHall);
        cinemaHallService.getAll().forEach(LOGGER::info);

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
        MovieSessionService movieSessionService = context.getBean(MovieSessionService.class);
        movieSessionService.add(sessionOne);
        movieSessionService.add(sessionTwo);
        List<MovieSession> sessions = movieSessionService.findAvailableSessions(movie.getId(),
                LocalDate.of(2020, 5, 22));
        sessions.forEach(LOGGER::info);
        User user = new User();
        user.setEmail("user@user.com");
        user.setName("user1");
        user.setSalt(HashUtil.getSalt());
        user.setPassword(HashUtil.hashPassword("1234", user.getSalt()));
        UserService userService = context.getBean(UserService.class);
        LOGGER.info(userService.add(user));
        LOGGER.info(userService.findByEmail("user@user.com"));
        AuthenticationService authenticationService
                = context.getBean(AuthenticationService.class);
        String email = "userFromService@user.com";
        authenticationService.register(email, "1234");
        LOGGER.info(authenticationService.login(email, "1234"));

        ShoppingCartService shoppingCartService =
                context.getBean(ShoppingCartService.class);

        User user2 = userService.findByEmail(email).orElse(null);

        shoppingCartService.addSession(sessionOne, user2);
        ShoppingCart shoppingCart = shoppingCartService.getByUser(user2);
        LOGGER.info(shoppingCart);

        OrderService orderService = context.getBean(OrderService.class);
        LOGGER.info(orderService.completeOder(shoppingCart.getTickets(), user2));
        LOGGER.info(orderService.getOrderHistory(user2));
    }
}

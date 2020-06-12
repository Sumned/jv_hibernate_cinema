package com.dev.cinema.controller.shoppingcart;

import com.dev.cinema.mapper.ShoppingCartMapper;
import com.dev.cinema.model.dto.shoppingcart.ShoppingCartRequestDto;
import com.dev.cinema.model.dto.shoppingcart.ShoppingCartResponseDto;
import com.dev.cinema.service.MovieSessionService;
import com.dev.cinema.service.ShoppingCartService;
import com.dev.cinema.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/shopping-cart")
public class ShoppingCarController {
    private ShoppingCartService shoppingCartService;
    private ShoppingCartMapper shoppingCartMapper;
    private MovieSessionService movieSessionService;
    private UserService userService;

    public ShoppingCarController(ShoppingCartService shoppingCartService,
                                 ShoppingCartMapper shoppingCartMapper,
                                 MovieSessionService movieSessionService,
                                 UserService userService) {
        this.shoppingCartService = shoppingCartService;
        this.shoppingCartMapper = shoppingCartMapper;
        this.movieSessionService = movieSessionService;
        this.userService = userService;
    }

    @GetMapping(value = "/by-user")
    public ShoppingCartResponseDto getByUserId(@RequestParam Long userId) {
        return shoppingCartMapper.getShoppingCartFromResponseDto(
                shoppingCartService.getByUser(userService.getById(userId)));
    }

    @PostMapping(value = "/add-movie-session")
    public void addMovieSession(@RequestParam Long userId,
                                @RequestBody ShoppingCartRequestDto shoppingCartRequestDto) {
        shoppingCartService.addSession(movieSessionService
                        .getById(shoppingCartRequestDto.getMovieSessionId()),
                userService.getById(userId));
    }
}

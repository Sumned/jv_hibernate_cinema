package com.dev.cinema.controller.shoppingcart;

import com.dev.cinema.exceptions.DataProcessingException;
import com.dev.cinema.mapper.ShoppingCartMapper;
import com.dev.cinema.model.dto.shoppingcart.ShoppingCartRequestDto;
import com.dev.cinema.model.dto.shoppingcart.ShoppingCartResponseDto;
import com.dev.cinema.service.MovieSessionService;
import com.dev.cinema.service.ShoppingCartService;
import com.dev.cinema.service.UserService;
import javax.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/shopping-cart")
public class ShoppingCarController {
    private final ShoppingCartService shoppingCartService;
    private final ShoppingCartMapper shoppingCartMapper;
    private final MovieSessionService movieSessionService;
    private final UserService userService;

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
    public ShoppingCartResponseDto getByUserId(Authentication authentication) {
        return shoppingCartMapper.getShoppingCartFromResponseDto(
                shoppingCartService.getByUser(userService
                        .findByEmail(authentication.getName()).orElseThrow()));
    }

    @PostMapping(value = "/add-movie-session")
    public void addMovieSession(Authentication authentication,
                                @RequestBody @Valid ShoppingCartRequestDto shoppingCartRequestDto) {
        shoppingCartService.addSession(movieSessionService
                        .getById(shoppingCartRequestDto.getMovieSessionId()),
                userService.findByEmail(authentication.getName())
                        .orElseThrow(() -> new DataProcessingException("Can't gat user")));
    }
}

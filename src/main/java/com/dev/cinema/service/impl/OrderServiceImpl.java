package com.dev.cinema.service.impl;

import com.dev.cinema.dao.OrderDao;
import com.dev.cinema.lib.Inject;
import com.dev.cinema.lib.Injector;
import com.dev.cinema.lib.Service;
import com.dev.cinema.model.Order;
import com.dev.cinema.model.Ticket;
import com.dev.cinema.model.User;
import com.dev.cinema.service.OrderService;
import com.dev.cinema.service.ShoppingCartService;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private static final Injector INJECTOR = Injector.getInstance("com.dev.cinema");

    @Inject
    private OrderDao orderDao;

    @Override
    public Order completeOder(List<Ticket> tickets, User user) {
        Order order = new Order(List.copyOf(tickets), user, LocalDateTime.now());
        ShoppingCartService shoppingCartService =
                (ShoppingCartService) INJECTOR.getInstance(ShoppingCartService.class);
        shoppingCartService.clear(shoppingCartService.getByUser(user));
        return orderDao.add(order);
    }

    @Override
    public List<Order> getOrderHistory(User user) {
        return orderDao.getOrderHistory(user);
    }
}

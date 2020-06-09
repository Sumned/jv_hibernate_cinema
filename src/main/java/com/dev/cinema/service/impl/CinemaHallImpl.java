package com.dev.cinema.service.impl;

import com.dev.cinema.dao.CinemaHallDao;
import com.dev.cinema.model.CinemaHall;
import com.dev.cinema.service.CinemaHallService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CinemaHallImpl implements CinemaHallService {
    private CinemaHallDao cinemaHallDao;

    public CinemaHallImpl(CinemaHallDao cinemaHallDao) {
        this.cinemaHallDao = cinemaHallDao;
    }

    @Override
    public CinemaHall add(CinemaHall cinemaHall) {
        return cinemaHallDao.add(cinemaHall);
    }

    @Override
    public List<CinemaHall> getAll() {
        return cinemaHallDao.getAll();
    }
}

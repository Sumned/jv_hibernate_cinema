package com.dev.cinema.service;

import com.dev.cinema.model.MovieSession;
import java.time.LocalDate;
import java.util.List;

public interface MovieSessionService {
    MovieSession add(MovieSession session);

    MovieSession getById(Long id);

    List<MovieSession> getAll();

    List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);
}

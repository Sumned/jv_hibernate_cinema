package com.dev.cinema.dao;

import com.dev.cinema.model.MovieSession;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface MovieSessionDao {
    MovieSession add(MovieSession movieSession);

    List<MovieSession> getAll();

    Optional<MovieSession> getById(Long id);

    List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);
}

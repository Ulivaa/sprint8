package ru.yandex.practicum.filmorate.controller;

import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.dto.FilmDto;
import ru.yandex.practicum.filmorate.model.Film;

import java.time.LocalDate;
import java.util.*;

@RestController
public class FilmController {
    private Map<Integer, Film> films = new HashMap<>();

    @PostMapping
    public void addFilm(@RequestBody FilmDto filmDto) {

        Film film = filmDto.mapToFilm(filmDto);

        // может быть пустой дескрипшн
        if (film.getDescription()== null || film.getDescription().length() > 200 || film.getDuration().isNegative() || film.getDate().isBefore(LocalDate.of(1895, 12, 28))) {
            throw new RuntimeException("Неверный формат данных");
        }
        films.put(film.getId(), film);

    }

    @PutMapping
    public void updateFilm(@RequestBody Film film) {

        films.put(film.getId(), film);

    }

    @GetMapping
    public Collection<Film> returnAllFilms() {
        return films.values();
    }

}

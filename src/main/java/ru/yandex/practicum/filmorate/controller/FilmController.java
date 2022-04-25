package ru.yandex.practicum.filmorate.controller;

import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.dto.FilmDto;
import ru.yandex.practicum.filmorate.model.Film;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

@RestController
public class FilmController {
    private Map<Integer, Film> films = new HashMap<>();

//    @PostMapping
//    public void addFilm(@RequestBody Film film) {
//
//        Film film = filmDto.mapToFilm(filmDto);
//
//        // может быть пустой дескрипшн
////        if (film.getDescription()== null || film.getDescription().length() > 200 || film.getDuration().isNegative() || film.getDate().isBefore(LocalDate.of(1895, 12, 28))) {
////            throw new RuntimeException("Неверный формат данных");
////        }
////        films.put(film.getId(), film);
//
//    }
    @PostMapping("/film")
    public void addFilm(@RequestBody FilmDto filmDto) {

        Film film = filmDto.mapToFilm(filmDto);

        // может быть пустой дескрипшн
        if ((film.getDescription()!= null && film.getDescription().length() > 200) || film.getDuration().isNegative() || film.getDate().isBefore(LocalDate.of(1895, 12, 28))) {
            throw new RuntimeException("Неверный формат данных");
        }
        films.put(film.getId(), film);

    }

    @PutMapping("/film")
    public void updateFilm(@RequestBody Film film) {
        if ( film.getId() == 0 || (film.getDescription()!= null && film.getDescription().length() > 200) || film.getDuration().isNegative() || film.getDate().isBefore(LocalDate.of(1895, 12, 28))) {
            throw new RuntimeException("Неверный формат данных");
        }
        films.put(film.getId(), film);

    }

    @GetMapping("/films")
    public Collection<Film> returnAllFilms() {
//        films.put(1, new Film(1, "name", "descriptions", LocalDate.of(1997, Month.APRIL, 15), Duration.ofMinutes(139)));
        return films.values();
    }

}


//{
//        "id": 1,
//        "name": "name",
//        "description": "descriptions",
//        "date": "1997-04-15",
//        "duration": "PT2H"
//    }


//{
//        "id": 1,
//        "name": "name",
//        "description": "descriptions",
//        "date": "1997-04-15",
//        "duration": "PT2H19M"
//    }
package ru.yandex.practicum.filmorate.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import ru.yandex.practicum.filmorate.model.Film;

import java.time.Duration;
import java.time.LocalDate;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class FilmDto {

    static int id = 0;
    @NonNull String name;
    String description;
    // можно принимать как стринг и потом парсить в норм переменную,
    LocalDate date;
    Duration duration;

    public Film mapToFilm(FilmDto filmDto){

        Film film = new Film(filmDto.getName());
        film.setId(++id);
        film.setDate(filmDto.getDate());
        film.setDescription(filmDto.getDescription());
        film.setDuration(filmDto.getDuration());
        return film;
    }


}

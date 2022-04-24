package ru.yandex.practicum.filmorate.model;

import lombok.Data;
import lombok.NonNull;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
public class Film {
    protected static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    int id;
    @NonNull String name;
    String description;
    LocalDate date;
    Duration duration;
}

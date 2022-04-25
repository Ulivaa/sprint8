package ru.yandex.practicum.filmorate.model;

import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class User {
    protected static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    int id;
    @NonNull String login;
    @NonNull String email;
    String name;
    LocalDate birthday;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return email.equals(user.getEmail());
    }
    @Override
    public int hashCode() {
        return Objects.hash(email);
    }
}

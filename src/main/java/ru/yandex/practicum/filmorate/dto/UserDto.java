package ru.yandex.practicum.filmorate.dto;

import lombok.*;
import ru.yandex.practicum.filmorate.model.Film;
import ru.yandex.practicum.filmorate.model.User;

import java.time.LocalDate;

@Setter
@Getter
@RequiredArgsConstructor
public class UserDto {
    int id;
    @NonNull String login;
    @NonNull String email;
    String name;
    LocalDate birthday;

    public User mapToUser(UserDto userDto) {
        User user = new User(userDto.getLogin(), userDto.getEmail());
        user.setId(id++);
        user.setName(userDto.getName());
        user.setBirthday(userDto.getBirthday());
        return user;
    }
}

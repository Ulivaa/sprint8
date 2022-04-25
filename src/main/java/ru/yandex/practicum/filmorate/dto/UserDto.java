package ru.yandex.practicum.filmorate.dto;

import lombok.*;
import ru.yandex.practicum.filmorate.model.Film;
import ru.yandex.practicum.filmorate.model.User;

import java.time.LocalDate;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
public class UserDto {
    static int id = 0;
    @NonNull String login;
    @NonNull String email;
    String name;
    LocalDate birthday;

    public User mapToUser(UserDto userDto) {
        User user = new User(userDto.getLogin(), userDto.getEmail());
        user.setId(++id);
        if (userDto.getName() == null){
            user.setName(userDto.getLogin());
        } else {
        user.setName(userDto.getName());}
        if (userDto.birthday.isAfter(LocalDate.now())){
            throw new RuntimeException("День рождения не может быть в будущем");
        } else {
        user.setBirthday(userDto.getBirthday());}
        return user;
    }
}

package ru.yandex.practicum.filmorate.controller;

import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.dto.UserDto;
import ru.yandex.practicum.filmorate.model.User;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;


@RestController
public class UserController {
    private Map< Integer, User> users = new HashMap<>();

//    @PostMapping
//    public void createUser(@RequestBody User user){
//        User user = userDto.mapToUser(userDto);
//        users.put(user.getId(), user);

//    }

    @PostMapping("/user")
    public void createUser(@RequestBody UserDto userDto){
        User user = userDto.mapToUser(userDto);


        if (user.getLogin().contains(" ") || !user.getEmail().contains("@") ) {
            throw new RuntimeException("Неверный формат данных");
        }

        users.put(user.getId(), user);

    }
    @PutMapping("/user")
    public void updateUser(@RequestBody User user){
//        users.put(user.getId(), user);

    }

    @GetMapping("/users")
    public Collection<User> returnAllUsers(){

//        users.put(1, new User(1, "login", "email", "name", LocalDate.of(1996, Month.APRIL, 16)));
        return users.values();
    }
}


//{
//        "id": 1,
//        "login": "login",
//        "email": "email",
//        "name": "name",
//        "birthday": "1996-04-16"
//    }
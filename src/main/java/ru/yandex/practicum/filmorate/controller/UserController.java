package ru.yandex.practicum.filmorate.controller;

import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.dto.UserDto;
import ru.yandex.practicum.filmorate.model.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    private Map< Integer, User> users = new HashMap<>();

    @PostMapping
    public void createUser(@RequestBody UserDto userDto){
        User user = userDto.mapToUser(userDto);
        users.put(user.getId(), user);

    }

    @PutMapping
    public void updateUser(@RequestBody User user){
        users.put(user.getId(), user);

    }

    @GetMapping
    public Collection<User> returnAllUsers(){
        return users.values();
    }
}

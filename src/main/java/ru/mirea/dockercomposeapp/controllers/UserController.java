package ru.mirea.dockercomposeapp.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.mirea.dockercomposeapp.dto.DtoConverter;
import ru.mirea.dockercomposeapp.dto.UserDto;
import ru.mirea.dockercomposeapp.dto.UserDtoList;
import ru.mirea.dockercomposeapp.services.UserService;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final DtoConverter dtoConverter;

    @PostMapping
    public String addNewUser(@RequestBody UserDto userDto) {
        userService.saveUser(userDto);
        return "User was saved";
    }

    @GetMapping
    public UserDtoList getAllUsers() {
        return userService.getAllUsers(dtoConverter::toUserDtoList);
    }
}

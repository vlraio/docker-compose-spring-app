package ru.mirea.dockercomposeapp.controllers;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.mirea.dockercomposeapp.dto.DtoConverter;
import ru.mirea.dockercomposeapp.dto.UserDto;
import ru.mirea.dockercomposeapp.dto.UserDtoResponseList;
import ru.mirea.dockercomposeapp.dto.UserDtoResponse;
import ru.mirea.dockercomposeapp.services.UserService;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    private final DtoConverter dtoConverter;

    @PostMapping
    public UserDtoResponse addNewUser(@RequestBody @Valid UserDto userDto) {
        return userService.save(userDto);
    }

    @PutMapping("/avatar")
    public UserDtoResponse addUserAvatar(@RequestPart MultipartFile avatar, @RequestParam long userId) throws NotFoundException, IOException {
        return userService.addAvatar(avatar, userId);
    }

    @GetMapping
    public UserDtoResponseList getAllUsers() {
        return userService.getAllUsers(dtoConverter::toUserDtoResponseList);
    }
}

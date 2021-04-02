package ru.mirea.dockercomposeapp.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDtoList {
    private List<UserDto> userDtos;
}

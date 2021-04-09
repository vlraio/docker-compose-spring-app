package ru.mirea.dockercomposeapp.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDtoResponseList {
    private List<UserDtoResponse> userDtos;
}

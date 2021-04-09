package ru.mirea.dockercomposeapp.dto;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class UserDto {
    @Size(max = 50)
    private String firstName;

    @Size(max = 50)
    private String secondName;

    private int age;
}

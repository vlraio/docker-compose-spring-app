package ru.mirea.dockercomposeapp.dto;

import org.springframework.stereotype.Component;
import ru.mirea.dockercomposeapp.models.User;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DtoConverter {

    public UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setFirstName(user.getFirstName());
        userDto.setSecondName(user.getSecondName());
        userDto.setAge(user.getAge());
        return userDto;
    }

    public UserDtoList toUserDtoList(List<User> users) {
        UserDtoList userDtoList = new UserDtoList();
        userDtoList.setUserDtos(
                users.stream()
                        .map(this::toUserDto)
                        .collect(Collectors.toList())
        );
        return userDtoList;
    }
}

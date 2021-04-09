package ru.mirea.dockercomposeapp.dto;

import org.springframework.stereotype.Component;
import ru.mirea.dockercomposeapp.models.User;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DtoConverter {

    public UserDtoResponse toUserDto(User user) {
        return UserDtoResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .secondName(user.getSecondName())
                .age(user.getAge())
                .avatar(user.getAvatar())
                .build();
    }

    public UserDtoResponseList toUserDtoResponseList(List<User> users) {
        UserDtoResponseList userDtoList = new UserDtoResponseList();
        userDtoList.setUserDtos(
                users.stream()
                        .map(this::toUserDto)
                        .collect(Collectors.toList())
        );
        return userDtoList;
    }
}

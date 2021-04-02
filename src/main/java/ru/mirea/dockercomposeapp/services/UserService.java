package ru.mirea.dockercomposeapp.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mirea.dockercomposeapp.dto.UserDto;
import ru.mirea.dockercomposeapp.models.User;
import ru.mirea.dockercomposeapp.repositories.UserRepository;

import java.util.List;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void saveUser(UserDto userDto) {
        User user = User.builder()
                .firstName(userDto.getFirstName())
                .secondName(userDto.getSecondName())
                .age(userDto.getAge())
                .build();
        userRepository.save(user);
    }

    @Transactional
    public <T> T getAllUsers(Function<List<User>, T> toDto) {
        List<User> users = userRepository.findAll();
        return toDto.apply(users);
    }
}

package ru.mirea.dockercomposeapp.services;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ru.mirea.dockercomposeapp.dto.UserDto;
import ru.mirea.dockercomposeapp.dto.UserDtoResponse;
import ru.mirea.dockercomposeapp.models.User;
import ru.mirea.dockercomposeapp.repositories.UserRepository;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    private final PhotoService photoService;

    @Value("${server.port}")
    private String serverPort;

    @Transactional
    public UserDtoResponse save(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setSecondName(userDto.getSecondName());
        user.setAge(userDto.getAge());
        userRepository.save(user);

        return UserDtoResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .secondName(user.getSecondName())
                .age(user.getAge())
                .avatar(user.getAvatar())
                .build();
    }

    @Transactional
    public <T> T getAllUsers(Function<List<User>, T> toDto) {
        List<User> users = userRepository.findAll();
        return toDto.apply(users);
    }

    @Transactional
    public UserDtoResponse addAvatar(MultipartFile avatar, long userId) throws IOException, NotFoundException {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException("User with id " + userId + " was not found"));
        String avatarId = photoService.save(avatar);
        user.setAvatar(new URL("http://localhost:" + serverPort + "/img/usr/" + avatarId));

        return UserDtoResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .secondName(user.getSecondName())
                .age(user.getAge())
                .avatar(user.getAvatar())
                .build();
    }
}

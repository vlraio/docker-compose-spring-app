package ru.mirea.dockercomposeapp.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.net.URL;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDtoResponse {
    @NotNull
    private Long id;

    @Size(max = 50)
    private String firstName;

    @Size(max = 50)
    private String secondName;

    private int age;

    @Size(max = 100)
    private URL avatar;
}

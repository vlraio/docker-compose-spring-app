package ru.mirea.dockercomposeapp.models;

import lombok.*;

import javax.persistence.*;
import java.net.URL;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String firstName;

    @Column(length = 50)
    private String secondName;

    private int age;

    @Column(length = 100)
    private URL avatar;
}

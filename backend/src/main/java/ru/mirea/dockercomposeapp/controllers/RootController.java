package ru.mirea.dockercomposeapp.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/")
public class RootController {
    private static final String WELCOME = "It's a docker compose app!";

    @GetMapping
    public String index() {
        log.error(WELCOME);
        return WELCOME;
    }
}

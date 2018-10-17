package ru.itpark.trader.controller;

import org.springframework.stereotype.Controller;
import ru.itpark.trader.service.UserService;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
}

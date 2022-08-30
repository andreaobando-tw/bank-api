package com.tw.bankapi.controller;

import com.tw.bankapi.mapping.dto.UserDTO;
import com.tw.bankapi.mapping.interfaces.UserMapper;
import com.tw.bankapi.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "user")
public class UserController {

    final
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> findAll() {
        return UserMapper.INSTANCE.map(userService.findAll());
    }
}

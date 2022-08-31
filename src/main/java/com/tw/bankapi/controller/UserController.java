package com.tw.bankapi.controller;

import com.tw.bankapi.mapping.dto.UserDTO;
import com.tw.bankapi.mapping.interfaces.UserMapper;
import com.tw.bankapi.params.mapping.dto.LoginParam;
import com.tw.bankapi.service.UserService;
import com.tw.bankapi.util.ResponseInformation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tw.bankapi.util.ResponseManager;

import java.util.List;

@RestController
@RequestMapping(path = "user")
public class UserController extends ResponseManager{

    final
    UserService userService;

    public UserController(UserService userService, ResponseInformation responseInformation) {
        super(responseInformation);
        this.userService = userService;
    }

    @GetMapping(value = "findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> findAll() {
        return UserMapper.INSTANCE.map(userService.findAll());
    }

    @PostMapping(value ="login", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO FindByUserNameAndPassword(@RequestBody LoginParam loginParam){
        return UserMapper.INSTANCE.entityToDto(userService.findByUserNameAndPassword(loginParam.getUsername(), loginParam.getPassword()));
    }
}

package com.ggastudios.urano.controller;

import com.ggastudios.urano.DTO.User;
import com.ggastudios.urano.DTO.UserResponse;
import com.ggastudios.urano.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/insert",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserResponse insert(@RequestBody User user){
        return userService.save(user);
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public UserResponse getById(@PathVariable("id")String id){
        return userService.getById(id);
    }

    @PostMapping(value = "/update",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserResponse update(@RequestBody User user){
        return userService.update(user);
    }

}

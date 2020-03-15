package com.ggastudios.urano.controller;

import com.ggastudios.urano.DTO.UserRequest;
import com.ggastudios.urano.DTO.UserResponse;
import com.ggastudios.urano.bean.UserBean;
import com.ggastudios.urano.exception.UserNotFoundException;
import com.ggastudios.urano.service.UserService;
import com.ggastudios.urano.utils.MappersBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping(value = "/users/application")
public class UserAplicationController {

    @Autowired
    private UserService userService;

    @Autowired
    private MappersBean<UserRequest,UserBean,UserResponse> mapGet;

    @GetMapping(value = "/{idApplication}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getByIdApplicationAndUsername(
            @PathVariable(value = "idApplication")String idApplication) throws UserNotFoundException {
        List<UserResponse> userResponseList = userService.getByIdApplication(idApplication).stream()
                .map(bean -> mapGet.beanToResponse(bean,UserResponse.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(userResponseList);
    }

    @GetMapping(value = "/{idApplication}/{username}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getByIdApplicationAndUsername(
            @PathVariable(value = "idApplication")String idApplication,
            @PathVariable("username")String username) throws UserNotFoundException {
        UserBean bean = userService.getByIdApplicationAndUsername(idApplication,username);
        UserResponse response = mapGet.beanToResponse(bean,UserResponse.class);
        return ResponseEntity.ok(response);
    }

}

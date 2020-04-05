package com.ggastudios.urano.controller;

import com.ggastudios.urano.DTO.UserInsertResponse;
import com.ggastudios.urano.DTO.UserRequest;
import com.ggastudios.urano.DTO.UserUpdateRequest;
import com.ggastudios.urano.bean.UserBean;
import com.ggastudios.urano.DTO.UserResponse;
import com.ggastudios.urano.exception.UserExistsException;
import com.ggastudios.urano.exception.UserNotFoundException;
import com.ggastudios.urano.service.UserService;
import com.ggastudios.urano.utils.MappersBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MappersBean<UserRequest,UserBean,UserResponse> mapGet;

    @Autowired
    private MappersBean<UserUpdateRequest,UserBean,UserResponse> mapUpdate;

    @Autowired
    private MappersBean<UserRequest,UserBean, UserInsertResponse> mapInsert;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> insert(@Valid @RequestBody UserRequest request) throws UserExistsException {
        UserBean beanRequest = mapInsert.map(request,UserBean.class);
        UserBean beanResponse = userService.insert(beanRequest);
        UserInsertResponse response = mapInsert.map(beanResponse,UserInsertResponse.class);
        return ResponseEntity.created(URI.create("")).body(response);
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@PathVariable("id")String id) throws UserNotFoundException {
        UserBean bean = userService.getById(id);
        UserResponse response = mapGet.map(bean,UserResponse.class);
        return ResponseEntity.ok(response);
    }

    @PatchMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@Valid @RequestBody UserUpdateRequest request, @PathVariable("id")String id)
    {
        UserBean beanRequest = mapUpdate.map(request,UserBean.class);
        UserBean beanresponse = userService.update(beanRequest,id);
        UserResponse response = mapUpdate.map(beanresponse,UserResponse.class);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/{id}",produces = MediaType.TEXT_XML_VALUE)
    public ResponseEntity<?> delete (@PathVariable("id")String id){
        userService.delete(id);
        ResponseEntity<String> responseEntity = new ResponseEntity("Usuario eliminado correctamente",HttpStatus.NO_CONTENT);
        return responseEntity;
    }
}

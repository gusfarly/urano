package com.ggastudios.urano.controller;

import com.ggastudios.urano.DTO.UserRequest;
import com.ggastudios.urano.bean.UserBean;
import com.ggastudios.urano.DTO.UserResponse;
import com.ggastudios.urano.service.UserService;
import com.ggastudios.urano.utils.MappersBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MappersBean<UserRequest,UserBean,UserResponse> map;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> insert(@RequestBody UserRequest request){
        UserBean beanRequest = map.requestToBean(request,UserBean.class);
        UserBean beanResponse = userService.insert(beanRequest);
        UserResponse response = map.beanToResponse(beanResponse,UserResponse.class);
        return ResponseEntity.created(URI.create("")).body(response);
    }

    @GetMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@PathVariable("id")String id) throws Exception {
        UserBean bean = userService.getById(id);
        UserResponse response = map.beanToResponse(bean,UserResponse.class);
        return ResponseEntity.ok(response);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll () {
        List<UserResponse> userBeanList = userService.getAll().stream()
                .map(bean -> map.beanToResponse(bean,UserResponse.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(userBeanList);
    }

    @PatchMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@RequestBody UserRequest request,@PathVariable("id")String id)
    {
        UserBean beanRequest = map.requestToBean(request,UserBean.class);
        UserBean beanresponse = userService.update(beanRequest,id);
        UserResponse response = map.beanToResponse(beanresponse,UserResponse.class);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/{id}",produces = MediaType.TEXT_XML_VALUE)
    public ResponseEntity<?> delete (@PathVariable("id")String id){
        userService.delete(id);
        ResponseEntity<String> responseEntity = new ResponseEntity("Usuario eliminado correctamente",HttpStatus.NO_CONTENT);
        return responseEntity;
    }
}

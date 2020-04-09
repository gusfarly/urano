package com.ggastudios.urano.controller;

import com.ggastudios.urano.DTO.response.user.UserInsertResponse;
import com.ggastudios.urano.DTO.request.user.UserRequest;
import com.ggastudios.urano.DTO.request.user.UserUpdateRequest;
import com.ggastudios.urano.bean.UserBean;
import com.ggastudios.urano.DTO.response.user.UserResponse;
import com.ggastudios.urano.entities.UserEntity;
import com.ggastudios.urano.exception.ApplicationNotFoundException;
import com.ggastudios.urano.exception.UserNotFoundException;
import com.ggastudios.urano.service.UserService;
import com.ggastudios.urano.utils.MappersBean;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    public ResponseEntity<?> insert(@Valid @RequestBody UserRequest request) throws ApplicationNotFoundException {
        UserBean beanRequest = mapInsert.map(request,UserBean.class);
        UserBean beanResponse = userService.insert(beanRequest);
        UserInsertResponse response = mapInsert.map(beanResponse,UserInsertResponse.class);
        return ResponseEntity.created(URI.create("")).body(response);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getFilter(
            @RequestParam(value = UserEntity.PARAM_APPLICATION,required = false) String idApplication,
            @RequestParam(value = UserEntity.PARAM_USERNAME,required = false) String username,
            @RequestParam(value = UserEntity.PARAM_EMAIL,required = false) String email,
            @RequestParam(value = UserEntity.PARAM_FACEBOOK,required = false) String facebookId,
            @RequestParam(value = UserEntity.PARAM_LANGUAGE,required = false) String language,
            @RequestParam(value = UserEntity.PARAM_COUNTRY,required = false) String country
    ) throws UserNotFoundException {
        Map<String,String> filter = new HashMap<>();
        filter.put(UserEntity.PARAM_APPLICATION,idApplication);
        if (StringUtils.isNotBlank(username)) filter.put(UserEntity.PARAM_USERNAME,username);
        if (StringUtils.isNotBlank(email)) filter.put(UserEntity.PARAM_EMAIL,email);
        if (StringUtils.isNotBlank(facebookId)) filter.put(UserEntity.PARAM_FACEBOOK,facebookId);
        if (StringUtils.isNotBlank(language)) filter.put(UserEntity.PARAM_LANGUAGE,language);
        if (StringUtils.isNotBlank(country)) filter.put(UserEntity.PARAM_COUNTRY,country);
        List<UserResponse> userResponseList = userService.findWithFilter(filter).stream()
                .map(bean -> mapGet.map(bean,UserResponse.class))
                .collect(Collectors.toList());
        return ResponseEntity.ok(userResponseList);
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
        return (ResponseEntity<?>) ResponseEntity.noContent();
    }
}

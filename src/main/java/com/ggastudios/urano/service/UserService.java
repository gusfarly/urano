package com.ggastudios.urano.service;

import com.ggastudios.urano.DTO.User;
import com.ggastudios.urano.DTO.UserResponse;
import com.ggastudios.urano.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserResponse save(User user){
        user.initDateStart();
        userRepository.save(user);
        return new UserResponse(user);
    }

    public UserResponse getById(String id){
        Optional<User> user = userRepository.findById(id);
        return new UserResponse(user.get());
    }

    public UserResponse update(User user){
        Optional<User> userToSave = userRepository.findById(user.getId());
        userToSave.get().update(user);
        userRepository.save(userToSave.get());
        return new UserResponse(user);
    }

}

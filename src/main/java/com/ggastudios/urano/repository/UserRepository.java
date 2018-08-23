package com.ggastudios.urano.repository;

import com.ggastudios.urano.DTO.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
}

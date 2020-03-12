package com.ggastudios.urano.repository;

import com.ggastudios.urano.entities.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserEntity,String> {
}

package com.ggastudios.urano.repository;

import com.ggastudios.urano.bean.UserBean;
import com.ggastudios.urano.entities.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.DoubleStream;

public interface UserRepository extends MongoRepository<UserEntity,String> {
    Optional<UserEntity> findByIdApplicationAndUsername(String idApplication, String username);

    List<UserEntity> findByIdApplication(String idApplication);

    int countByIdApplicationAndUsername(String idApplication,String username);
}

package com.ggastudios.urano.repository;

import com.ggastudios.urano.entities.PlayerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends MongoRepository<PlayerEntity,String> {
    
    Optional<PlayerEntity> findByIdApplicationAndUsername(String idApplication, String username);

    List<PlayerEntity> findByIdApplication(String idApplication);

    int countById(String id);
}

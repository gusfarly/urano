package com.ggastudios.urano.repository;

import com.ggastudios.urano.entities.AppEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AppRepository extends MongoRepository<AppEntity,String> {
    int countById(String idApplication);

}

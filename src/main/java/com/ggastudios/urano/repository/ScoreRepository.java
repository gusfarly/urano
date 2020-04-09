package com.ggastudios.urano.repository;

import com.ggastudios.urano.entities.ScoreEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ScoreRepository extends MongoRepository<ScoreEntity,String> {
    /**
     * devuelve las mejores puntuaciones para un nivel y una aplicacion
     * @param application
     * @param level
     * @param pageable
     * @return
     */
    List<ScoreEntity> findAllByApplicationAndLevelOrderByScoreDesc(String application, int level, Pageable pageable);

    int countByApplicationAndUserAndLevelEquals(String application,String user,int level);

    ScoreEntity findByApplicationAndUserAndLevelEquals(String application,String user,int level);

    List<ScoreEntity> findAllByApplicationAndLevelAndScoreIsLessThanOrderByScoreDesc(String application,int level,long score,Pageable pageable);

    List<ScoreEntity> findAllByApplicationAndLevelAndScoreIsGreaterThanEqualOrderByScoreAsc(String application,int level,long score,Pageable pageable);

}

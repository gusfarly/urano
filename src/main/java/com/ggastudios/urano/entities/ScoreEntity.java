package com.ggastudios.urano.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@Document(collection = "score")
public class ScoreEntity implements BaseEntity {

    @Id
    private String id;
    private String application;
    private int level;
    private long score;
    private String user;
    private String name;
    private int attempt;
    // todo cambiar estos campos por fechas reales.
    private Date dateUpdate;
    private Date dateLastAttempt;

}

package com.ggastudios.urano.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@EqualsAndHashCode
@NoArgsConstructor
public class ScoreBean implements BaseBean{

    private String id;
    private String application;
    private int level;
    private long score;
    private String player;
    private String name;
    private int attempt;
    private Date dateUpdate;
    private Date dateLastAttempt;

}

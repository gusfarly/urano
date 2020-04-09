package com.ggastudios.urano.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@NoArgsConstructor
public class ScoreBean implements BaseBean{

    private String id;
    private String application;
    private int level;
    private long score;
    private String user;
    private String name;
    private String dateUpdate;
    private int attempt;

}

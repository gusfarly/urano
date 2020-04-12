package com.ggastudios.urano.DTO.request.score;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ggastudios.urano.DTO.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode
@NoArgsConstructor
public class ScoreInsertRequest implements BaseRequest {

    @NonNull
    private String application;
    @NonNull
    private int level;
    @NonNull
    private String score;
    @NonNull
    private String player;
    private String name;

}

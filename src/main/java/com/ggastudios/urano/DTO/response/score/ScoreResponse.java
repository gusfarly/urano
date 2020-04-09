package com.ggastudios.urano.DTO.response.score;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ggastudios.urano.DTO.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class ScoreResponse implements BaseResponse {

    private long score;
    private String user;
    private String name;
    private String dateLastAttempt;
    private String dateUpdate;
    private int attempt;

}

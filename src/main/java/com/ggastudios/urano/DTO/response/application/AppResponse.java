package com.ggastudios.urano.DTO.response.application;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ggastudios.urano.DTO.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AppResponse implements BaseResponse {

    private String id;
    private String name;
    private String description;
    private String version;
    private String owner;
}

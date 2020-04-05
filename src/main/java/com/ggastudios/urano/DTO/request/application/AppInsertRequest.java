package com.ggastudios.urano.DTO.request.application;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ggastudios.urano.DTO.BaseRequest;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AppInsertRequest implements BaseRequest {

    private static final long serialVersionUID = 297222730885809142L;
    private String name;
    private String description;
    private String version;
    private String owner;
}

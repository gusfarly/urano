package com.ggastudios.urano.DTO.request.application;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ggastudios.urano.DTO.BaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class AppUpdateRequest implements BaseRequest {

    private static final long serialVersionUID = -8755225271806796008L;
    private String name;
    private String description;
    private String version;
    private String owner;
}

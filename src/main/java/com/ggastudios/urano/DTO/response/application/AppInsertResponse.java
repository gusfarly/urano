package com.ggastudios.urano.DTO.response.application;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ggastudios.urano.DTO.BaseResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class AppInsertResponse implements BaseResponse {

    private static final long serialVersionUID = 6030224735751552283L;
    private String id;
}

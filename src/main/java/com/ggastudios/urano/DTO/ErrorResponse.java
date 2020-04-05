package com.ggastudios.urano.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ErrorResponse implements BaseResponse{

    private static final long serialVersionUID = 6436526981664933130L;
    private String message;
    private String code;

}

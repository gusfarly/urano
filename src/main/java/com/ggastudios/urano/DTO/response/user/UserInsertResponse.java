package com.ggastudios.urano.DTO.response.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ggastudios.urano.DTO.BaseResponse;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInsertResponse implements BaseResponse {

    private static final long serialVersionUID = -9049288360220542971L;
    private String id;
}

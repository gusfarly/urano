package com.ggastudios.urano.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponse implements BaseResponse {

    private String id;
    private String idApplication;
    private String username;
    private String email;
    private String facebookId;
    private String language;
    private String country;

}

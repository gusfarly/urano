package com.ggastudios.urano.DTO.response.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ggastudios.urano.DTO.BaseResponse;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponse implements BaseResponse {

    private static final long serialVersionUID = 4758851866038327046L;
    private String id;
    private String idApplication;
    private String username;
    private String email;
    private String facebookId;
    private String language;
    private String country;

}

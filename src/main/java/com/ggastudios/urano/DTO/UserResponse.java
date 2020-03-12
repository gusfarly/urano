package com.ggastudios.urano.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserResponse implements BaseResponse {

    private String id;
    private String email;
    private String facebookId;
    private String idioma;
    private String name;
    private String pais;

}

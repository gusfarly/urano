package com.ggastudios.urano.DTO.request.player;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ggastudios.urano.DTO.BaseRequest;
import lombok.Data;

import javax.validation.constraints.Email;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerUpdateRequest implements BaseRequest {

    private static final long serialVersionUID = -4016502390144318011L;
    @Email(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")
    private String email;
    private String facebookId;
    private String language;
    private String country;

}

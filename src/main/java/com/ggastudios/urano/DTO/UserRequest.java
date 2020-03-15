package com.ggastudios.urano.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRequest implements BaseRequest {

    @NotEmpty(message = "idApplication no puede estar vacio")
    private String idApplication;
    @NotEmpty(message = "username no puede estar vacio")
    private String username;
    @Email(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")
    private String email;
    private String facebookId;
    private String language;
    private String country;
}

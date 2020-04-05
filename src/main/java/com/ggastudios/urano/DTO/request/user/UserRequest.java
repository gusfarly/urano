package com.ggastudios.urano.DTO.request.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ggastudios.urano.DTO.BaseRequest;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRequest implements BaseRequest {

    private static final long serialVersionUID = 9220975882318256416L;
    @NotEmpty(message = "idApplication no puede estar vacio")
    private String idApplication;
    private String username;
    @Email(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$")
    private String email;
    private String facebookId;
    private String language;
    private String country;
}m
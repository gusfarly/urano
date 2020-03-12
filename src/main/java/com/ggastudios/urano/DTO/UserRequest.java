package com.ggastudios.urano.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ggastudios.urano.bean.BaseBean;
import lombok.Data;
import org.dozer.Mapping;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRequest implements BaseRequest {

    @JsonProperty(required = true)
    private String email;
    private String facebookId;
    @Mapping("idioma")
    private String language;
    private String name;
    @Mapping("pais")
    private String country;

}

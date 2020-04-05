package com.ggastudios.urano.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;

@Data
@EqualsAndHashCode
@Document(collection = "user")
public class UserEntity implements BaseEntity {

    @Transient
    public static final String PARAM_APPLICATION = "idApplication";
    @Transient
    public static final String PARAM_USERNAME = "username";
    @Transient
    public static final String PARAM_EMAIL = "email";
    @Transient
    public static final String PARAM_FACEBOOK = "facebookId";
    @Transient
    public static final String PARAM_LANGUAGE = "language";
    @Transient
    public static final String PARAM_COUNTRY = "country";

    @Id
    private String id;
    private String idApplication;
    private String username;
    private String email;
    private boolean emailConfirmado;
    private String facebookId;
    private String language;
    private String country;
    private String dateUpdate;
    private String dateStart;
    private String dateDelete;

}

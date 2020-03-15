package com.ggastudios.urano.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;
import java.util.Calendar;

@Data
@EqualsAndHashCode
@Document(collection = "user")
public class UserEntity implements BaseEntity {

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
    private Date dateDelete;

}

package com.ggastudios.urano.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Calendar;

@EqualsAndHashCode
@Data
@ToString
public class UserBean implements BaseBean {
    private String id;
    private String idApplication;
    private String dateStart;
    private String dateUpdate;
    private String email;
    private boolean emailConfirmado;
    private String facebookId;
    private String language;
    private String username;
    private String country;

}

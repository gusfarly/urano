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
    private Calendar dateStart;
    private Calendar dateUpdate;
    private String email;
    private boolean emailConfirmado;
    private String facebookId;
    private String idioma;
    private String name;
    private String pais;

}

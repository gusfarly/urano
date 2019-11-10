package com.ggastudios.urano.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Calendar;
import java.util.TimeZone;

@Document
@JsonIgnoreProperties
public class User {

    @Id
    private String id;
    private Calendar dateStart;
    private Calendar dateUpdate;
    @UniqueElements
    private String email;
    private boolean emailConfirmado;
    private String facebookId;
    private String idioma;
    private String name;
    private String pais;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Calendar getDateStart() {
        return dateStart;
    }

    public void setDateStart(Calendar dateStart) {
        this.dateStart = dateStart;
    }

    public Calendar getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Calendar dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEmailConfirmado() {
        return emailConfirmado;
    }

    public void setEmailConfirmado(boolean emailConfirmado) {
        this.emailConfirmado = emailConfirmado;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    // metodos
    public void initDateStart(){
        this.dateStart = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
    }

    public void update (User user){
        this.dateUpdate = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        this.email = user.getEmail();
        this.facebookId = user.facebookId;
        this.name = user.getName();
    }

}

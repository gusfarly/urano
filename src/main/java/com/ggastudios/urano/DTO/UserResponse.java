package com.ggastudios.urano.DTO;

public class UserResponse {

    private String id;
    private String email;
    private String facebookId;
    private String idioma;
    private String name;
    private String pais;

    public UserResponse(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.facebookId = user.getFacebookId();
        this.idioma = user.getIdioma();
        this.name = user.getName();
        this.pais = user.getPais();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}

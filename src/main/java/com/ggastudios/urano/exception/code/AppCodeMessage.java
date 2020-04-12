package com.ggastudios.urano.exception.code;

import org.springframework.beans.factory.annotation.Autowired;

public enum AppCodeMessage implements BaseCodeMessage {

    PLAYER_NOT_INSERT_FOR_APLLICATION("AP0001","application.exception.code.ap0001"),
    APPLICATION_NOT_EXISTS("AP0002","application.exception.code.ap0002");

    private String code;
    private String message;

    AppCodeMessage(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

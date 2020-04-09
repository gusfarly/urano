package com.ggastudios.urano.exception.code;

public enum UserCodeMessage implements BaseCodeMessage{

    USER_NOT_FOUND("US0001","user.exception.code.us0001"),
    ID_NOT_FOUND("US0002","user.exception.code.us0002");

    private final String code;
    private final String message;

    UserCodeMessage(String code, String message) {
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

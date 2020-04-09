package com.ggastudios.urano.exception.code;

public enum ScoreCodeMessage implements BaseCodeMessage {
    MULTISCORE("SC0001","score.exception.code.sc0001"),
    USER_NOT_FOUND("SC0002","score.exception.code.sc0002"),
    APP_NOT_FOUND("SC0003","score.exception.code.sc0003");

    private String code;
    private String message;


    ScoreCodeMessage(String code, String message) {
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

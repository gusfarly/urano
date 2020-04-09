package com.ggastudios.urano.exception;

import lombok.Data;

@Data
public class UranoException extends Exception {


    private String code;

    public UranoException() {
    }

    public UranoException(String code) {
        this.code = code;
    }

    public UranoException(String message, String code) {
        super(message);
        this.code = code;
    }

    public UranoException(String message, Throwable cause, String code) {
        super(message, cause);
        this.code = code;
    }

    public UranoException(Throwable cause, String code) {
        super(cause);
        this.code = code;
    }

    public UranoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String code) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }
}

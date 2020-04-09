package com.ggastudios.urano.exception;

public class ScoreException extends UranoException {

    private static final long serialVersionUID = 6175919385999714520L;

    public static final String MULTISCORE_CODE = "SC0001";

    public ScoreException() {
    }

    public ScoreException(String code) {
        super(code);
    }

    public ScoreException(String message, String code) {
        super(message, code);
    }

    public ScoreException(String message, Throwable cause, String code) {
        super(message, cause, code);
    }

    public ScoreException(Throwable cause, String code) {
        super(cause, code);
    }

    public ScoreException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String code) {
        super(message, cause, enableSuppression, writableStackTrace, code);
    }
}

package com.ggastudios.urano.exception;

public class ApplicationException extends UranoException {

    private static final long serialVersionUID = -7890555220149808900L;

    public static final String CODE_APPLICATION_NOT_FOUND = "AP0001";
    public static final String MESSAGE_APPLICATION_NOT_FOUND = "application.exception.code.ap0001";
    public static final String CODE_APPLICATION_NOT_EXIST = "AP0002";
    public static final String MESSAGE_APPLICATION_NOT_EXIST = "application.exception.code.ap0002";

    public ApplicationException() {
    }

    public ApplicationException(String code) {
        super(code);
    }

    public ApplicationException(String message, String code) {
        super(message, code);
    }

    public ApplicationException(String message, Throwable cause, String code) {
        super(message, cause, code);
    }

    public ApplicationException(Throwable cause, String code) {
        super(cause, code);
    }

    public ApplicationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String code) {
        super(message, cause, enableSuppression, writableStackTrace, code);
    }
}

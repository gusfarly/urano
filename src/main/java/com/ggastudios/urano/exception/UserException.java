package com.ggastudios.urano.exception;

public class UserException extends UranoException {

    private static final long serialVersionUID = -2457049377488244911L;

    public static final String CODE_USER_NOT_FOUND = "US0001";
    public static final String MESSAGE_USER_NOT_FOUND = "user.exception.code.us0001";
    public static final String CODE_USER_NOT_FOUND_ID = "US0002";
    public static final String MESSAGE_USER_NOT_FOUND_ID = "user.exception.code.us0002";


    public UserException() {
    }

    public UserException(String code) {
        super(code);
    }

    public UserException(String message, String code) {
        super(message, code);
    }

    public UserException(String message, Throwable cause, String code) {
        super(message, cause, code);
    }

    public UserException(Throwable cause, String code) {
        super(cause, code);
    }

    public UserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String code) {
        super(message, cause, enableSuppression, writableStackTrace, code);
    }
}

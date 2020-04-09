package com.ggastudios.urano.exception;

public class UserNotFoundException extends UserException {

    private static final long serialVersionUID = 4567213329813954255L;

    public UserNotFoundException() {
        super(UserException.CODE_USER_NOT_FOUND);
    }

    public UserNotFoundException(String message, String code) {
        super(message, code);
    }

    public UserNotFoundException(String message) {
        super(message,UserException.CODE_USER_NOT_FOUND);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause, UserException.CODE_USER_NOT_FOUND);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause, UserException.CODE_USER_NOT_FOUND);
    }

    public UserNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace, UserException.CODE_USER_NOT_FOUND);
    }
}

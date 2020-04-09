package com.ggastudios.urano.exception;

public class UserExistsException extends UserException{

    private static final long serialVersionUID = 4300324854625676324L;

    public UserExistsException() {
        super(UserException.CODE_USER_EXISTS);
    }

    public UserExistsException(String message) {
        super(message, UserException.CODE_USER_EXISTS);
    }

    public UserExistsException(String message, Throwable cause) {
        super(message, cause, UserException.CODE_USER_EXISTS);
    }

    public UserExistsException(Throwable cause) {
        super(cause, UserException.CODE_USER_EXISTS);
    }

    public UserExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace, UserException.CODE_USER_EXISTS);
    }
}

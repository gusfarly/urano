package com.ggastudios.urano.exception;

import com.ggastudios.urano.exception.code.BaseCodeMessage;

public class UserNotFoundException extends UserException {

    private static final long serialVersionUID = 4567213329813954255L;

    public UserNotFoundException(BaseCodeMessage codeMessage) {
        super(codeMessage);
    }

    public UserNotFoundException(BaseCodeMessage codeMessage,Object... args) {
        super(codeMessage,args);
    }

    public UserNotFoundException(String message, Throwable cause, BaseCodeMessage codeMessage) {
        super(message, cause, codeMessage);
    }

    public UserNotFoundException(Throwable cause, BaseCodeMessage codeMessage) {
        super(cause, codeMessage);
    }

    public UserNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, BaseCodeMessage codeMessage) {
        super(message, cause, enableSuppression, writableStackTrace, codeMessage);
    }
}

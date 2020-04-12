package com.ggastudios.urano.exception;

import com.ggastudios.urano.exception.code.BaseCodeMessage;

public class PlayerNotFoundException extends PlayerException {

    private static final long serialVersionUID = 4567213329813954255L;

    public PlayerNotFoundException(BaseCodeMessage codeMessage) {
        super(codeMessage);
    }

    public PlayerNotFoundException(BaseCodeMessage codeMessage, Object... args) {
        super(codeMessage,args);
    }

    public PlayerNotFoundException(String message, Throwable cause, BaseCodeMessage codeMessage) {
        super(message, cause, codeMessage);
    }

    public PlayerNotFoundException(Throwable cause, BaseCodeMessage codeMessage) {
        super(cause, codeMessage);
    }

    public PlayerNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, BaseCodeMessage codeMessage) {
        super(message, cause, enableSuppression, writableStackTrace, codeMessage);
    }
}

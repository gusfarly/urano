package com.ggastudios.urano.exception;

import com.ggastudios.urano.exception.code.BaseCodeMessage;

public class PlayerException extends UranoException {

    private static final long serialVersionUID = -2457049377488244911L;

    public PlayerException() {
    }

    public PlayerException(BaseCodeMessage codeMessage) {
        super(codeMessage);
    }

    public PlayerException(BaseCodeMessage codeMessage, Object... args) {
        super(codeMessage,args);
    }

    public PlayerException(String message, Throwable cause, BaseCodeMessage codeMessage) {
        super(message, cause, codeMessage);
    }

    public PlayerException(Throwable cause, BaseCodeMessage codeMessage) {
        super(cause, codeMessage);
    }

    public PlayerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, BaseCodeMessage codeMessage) {
        super(message, cause, enableSuppression, writableStackTrace, codeMessage);
    }
}

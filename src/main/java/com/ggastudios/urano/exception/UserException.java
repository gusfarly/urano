package com.ggastudios.urano.exception;

import com.ggastudios.urano.exception.code.BaseCodeMessage;

public class UserException extends UranoException {

    private static final long serialVersionUID = -2457049377488244911L;

    public UserException() {
    }

    public UserException(BaseCodeMessage codeMessage) {
        super(codeMessage);
    }

    public UserException(BaseCodeMessage codeMessage,Object... args) {
        super(codeMessage,args);
    }

    public UserException(String message, Throwable cause, BaseCodeMessage codeMessage) {
        super(message, cause, codeMessage);
    }

    public UserException(Throwable cause, BaseCodeMessage codeMessage) {
        super(cause, codeMessage);
    }

    public UserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, BaseCodeMessage codeMessage) {
        super(message, cause, enableSuppression, writableStackTrace, codeMessage);
    }
}

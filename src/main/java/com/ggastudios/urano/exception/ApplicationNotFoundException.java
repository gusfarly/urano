package com.ggastudios.urano.exception;

import com.ggastudios.urano.exception.code.BaseCodeMessage;

public class ApplicationNotFoundException extends ApplicationException {
    private static final long serialVersionUID = -6656345815567529384L;

    public ApplicationNotFoundException(BaseCodeMessage codeMessage) {
        super(codeMessage);
    }

    public ApplicationNotFoundException(String message, Throwable cause, BaseCodeMessage codeMessage) {
        super(message, cause, codeMessage);
    }

    public ApplicationNotFoundException(Throwable cause, BaseCodeMessage codeMessage) {
        super(cause, codeMessage);
    }

    public ApplicationNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, BaseCodeMessage codeMessage) {
        super(message, cause, enableSuppression, writableStackTrace, codeMessage);
    }
}

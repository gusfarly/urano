package com.ggastudios.urano.exception;

import com.ggastudios.urano.exception.code.BaseCodeMessage;

public class ApplicationException extends UranoException {

    private static final long serialVersionUID = -7890555220149808900L;

    public ApplicationException() {
    }

    public ApplicationException(BaseCodeMessage codeMessage) {
        super(codeMessage);
    }


    public ApplicationException(String message, Throwable cause, BaseCodeMessage codeMessage) {
        super(message, cause, codeMessage);
    }

    public ApplicationException(Throwable cause, BaseCodeMessage codeMessage) {
        super(cause, codeMessage);
    }

    public ApplicationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, BaseCodeMessage codeMessage) {
        super(message, cause, enableSuppression, writableStackTrace, codeMessage);
    }
}

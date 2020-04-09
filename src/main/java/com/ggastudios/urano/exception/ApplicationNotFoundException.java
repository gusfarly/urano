package com.ggastudios.urano.exception;

public class ApplicationNotFoundException extends UranoException {
    private static final long serialVersionUID = -6656345815567529384L;

    public ApplicationNotFoundException() {
        super(ApplicationException.CODE_APPLICATION_NOT_FOUND);
    }

    public ApplicationNotFoundException(String message) {
        super(message, ApplicationException.CODE_APPLICATION_NOT_FOUND);
    }

    public ApplicationNotFoundException(String message, Throwable cause) {
        super(message, cause, ApplicationException.CODE_APPLICATION_NOT_FOUND);
    }

    public ApplicationNotFoundException(Throwable cause) {
        super(cause, ApplicationException.CODE_APPLICATION_NOT_FOUND);
    }

    public ApplicationNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace, ApplicationException.CODE_APPLICATION_NOT_FOUND);
    }
}

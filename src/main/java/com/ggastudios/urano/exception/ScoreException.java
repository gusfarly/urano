package com.ggastudios.urano.exception;

import com.ggastudios.urano.exception.code.BaseCodeMessage;

public class ScoreException extends UranoException {

    private static final long serialVersionUID = 6175919385999714520L;


    public ScoreException() {
    }

    public ScoreException(BaseCodeMessage codeMessage) {
        super(codeMessage);
    }

    public ScoreException(String message, Throwable cause, BaseCodeMessage codeMessage) {
        super(message, cause, codeMessage);
    }

    public ScoreException(Throwable cause, BaseCodeMessage codeMessage) {
        super(cause, codeMessage);
    }

    public ScoreException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, BaseCodeMessage codeMessage) {
        super(message, cause, enableSuppression, writableStackTrace, codeMessage);
    }
}

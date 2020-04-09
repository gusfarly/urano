package com.ggastudios.urano.exception;

import com.ggastudios.urano.exception.code.BaseCodeMessage;
import lombok.Data;

@Data
public class UranoException extends Exception {

    private Object[] args;
    private BaseCodeMessage codeMessage;

    public UranoException() {
    }

    public UranoException(BaseCodeMessage codeMessage) {
        this.codeMessage = codeMessage;
    }
    public UranoException(BaseCodeMessage codeMessage,Object... args) {
        this.args = args;
        this.codeMessage = codeMessage;
    }

    public UranoException(String message, Throwable cause, BaseCodeMessage codeMessage) {
        super(message, cause);
        this.codeMessage = codeMessage;
    }

    public UranoException(Throwable cause, BaseCodeMessage codeMessage) {
        super(cause);
        this.codeMessage = codeMessage;
    }

    public UranoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, BaseCodeMessage codeMessage) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.codeMessage = codeMessage;
    }
}

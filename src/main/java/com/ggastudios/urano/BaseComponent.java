package com.ggastudios.urano;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.lang.Nullable;

public class BaseComponent {
    @Autowired
    private MessageSource messageSource;

    public String getMessage(String code){
        return messageSource.getMessage(code,null, LocaleContextHolder.getLocale());
    }

    public String getMessage(String code, @Nullable Object... args){
        return messageSource.getMessage(code,args, LocaleContextHolder.getLocale());
    }

}

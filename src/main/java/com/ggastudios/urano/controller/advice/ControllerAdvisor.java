package com.ggastudios.urano.controller.advice;


import com.ggastudios.urano.DTO.ErrorResponse;
import com.ggastudios.urano.exception.ApplicationNotFoundException;
import com.ggastudios.urano.exception.UranoException;
import com.ggastudios.urano.exception.PlayerNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {


    @Autowired
    MessageSource messageSource;

    @ExceptionHandler(ApplicationNotFoundException.class)
    public ResponseEntity<?> handleApplicacionNotFoundException(ApplicationNotFoundException ex){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setCode(ex.getCodeMessage().getCode());
        errorResponse.setMessage(getMessage(ex));
        log.error(String.format("code: %s - message: %s - exception: %s",ex.getCodeMessage().getCode(),getMessage(ex),ex.getMessage()));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(PlayerNotFoundException.class)
    public ResponseEntity<?> handlePlayerNotFoundException(PlayerNotFoundException ex){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(getMessage(ex));
        errorResponse.setCode(ex.getCodeMessage().getCode());
        log.error(String.format("code: %s - message: %s - exception: %s",ex.getCodeMessage().getCode(),getMessage(ex),ex.getMessage()));
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UranoException.class)
    public ResponseEntity handleUranopException(UranoException ex){
        ErrorResponse response = new ErrorResponse();
        response.setMessage(getMessage(ex));
        response.setCode(ex.getCodeMessage().getCode());
        log.error(String.format("code: %s - message: %s - exception: %s",ex.getCodeMessage().getCode(),getMessage(ex),ex.getMessage()));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDate.now());
        body.put("status", status.value());

        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        body.put("errors", errors);
        log.error(errors.toString());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    private String getMessage(UranoException ex){
        return messageSource.getMessage(ex.getCodeMessage().getMessage(),ex.getArgs(), LocaleContextHolder.getLocale());
    }

}

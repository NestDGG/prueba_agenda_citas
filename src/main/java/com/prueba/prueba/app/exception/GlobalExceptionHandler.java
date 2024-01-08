package com.prueba.prueba.app.exception;


import com.prueba.prueba.app.model.ResponseModel;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {CitaInvalidException.class})
    protected ResponseModel<Object> citaInvalidHandler(CitaInvalidException ex) {
        return ResponseModel.builder()
                .status(false)
                .code(ex.getResponseCode())
                .message(ex.getResponseCode().getMessage())
                .data(null)
                .build();
    }

}

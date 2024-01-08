package com.prueba.prueba.app.exception;

import com.prueba.prueba.app.util.ResponseCode;
import lombok.Getter;

@Getter
public class CitaInvalidException extends Exception {

    private final ResponseCode responseCode;


    public CitaInvalidException(ResponseCode responseCode) {
        this.responseCode = responseCode;
    }
}

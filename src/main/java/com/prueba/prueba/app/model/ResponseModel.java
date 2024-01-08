package com.prueba.prueba.app.model;


import com.prueba.prueba.app.util.ResponseCode;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ResponseModel<T>{

    private Boolean status;

    private ResponseCode code;

    private String message;

    private T data;

}

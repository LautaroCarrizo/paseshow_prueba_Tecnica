package com.lautaro.prueba_tecnica_paseshow.exception.exceptions;

public class ExternalValidationError extends RuntimeException{
    public ExternalValidationError (String mensaje){
        super(mensaje);
    }
}

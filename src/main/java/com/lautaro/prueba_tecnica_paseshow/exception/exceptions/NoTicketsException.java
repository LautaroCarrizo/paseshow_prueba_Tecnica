package com.lautaro.prueba_tecnica_paseshow.exception.exceptions;

public class NoTicketsException extends RuntimeException {
    public NoTicketsException(String mensaje) {
        super(mensaje);
    }
}

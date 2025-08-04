package com.lautaro.prueba_tecnica_paseshow.servicies;

import org.springframework.stereotype.Service;

@Service
public interface ClienteValidacionServicie {
    boolean validarClienteEndPointPaseshow(String nombre, String apellido);
}

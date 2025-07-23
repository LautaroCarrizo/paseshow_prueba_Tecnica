package com.lautaro.prueba_tecnica_paseshow.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TicketDTO {
    private Long id;
    private String evento;
    private Long costo;
    private Date fechaVigencia;
    private Long clienteId;
}

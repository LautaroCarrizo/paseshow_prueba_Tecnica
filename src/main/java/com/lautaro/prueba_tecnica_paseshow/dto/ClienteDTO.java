package com.lautaro.prueba_tecnica_paseshow.dto;


import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ClienteDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private Date fechaNacimiento;
    private List<TicketDTO> tickets;
}

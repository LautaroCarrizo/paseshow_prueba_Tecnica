package com.lautaro.prueba_tecnica_paseshow.servicies;

import com.lautaro.prueba_tecnica_paseshow.dto.TicketDTO;

import java.util.List;

public interface TicketServicie {
    public List<TicketDTO> getTickets();

    public TicketDTO getTicket(Long id);

    public TicketDTO postTicket(TicketDTO dto);

    public TicketDTO updateTicket(TicketDTO dto, Long id);

    public void deleteTicket();
}

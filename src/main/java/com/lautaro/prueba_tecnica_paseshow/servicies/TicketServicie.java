package com.lautaro.prueba_tecnica_paseshow.servicies;

import com.lautaro.prueba_tecnica_paseshow.dto.TicketDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TicketServicie {
    public List<TicketDTO> getAllTicketsServicie();

    public TicketDTO getTicketServicie(Long id);

    public TicketDTO postTicketServicie(TicketDTO dto);

    public TicketDTO updateTicketServicie(TicketDTO dto, Long id);

    public void deleteTicketServicie(Long id);
}

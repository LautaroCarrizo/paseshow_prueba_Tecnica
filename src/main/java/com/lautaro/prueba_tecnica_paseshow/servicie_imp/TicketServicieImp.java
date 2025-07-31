package com.lautaro.prueba_tecnica_paseshow.servicie_imp;
import com.lautaro.prueba_tecnica_paseshow.dto.TicketDTO;
import com.lautaro.prueba_tecnica_paseshow.model.Cliente;
import com.lautaro.prueba_tecnica_paseshow.model.Ticket;
import com.lautaro.prueba_tecnica_paseshow.repository.ClienteRepository;
import com.lautaro.prueba_tecnica_paseshow.repository.TicketRepository;
import com.lautaro.prueba_tecnica_paseshow.servicies.TicketServicie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketServicieImp implements TicketServicie {
    @Autowired
    private TicketRepository repo_ticket;
    @Autowired
    private ClienteRepository repo_cliente;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public List<TicketDTO> getAllTicketsServicie() {
        List<Ticket> ticketModel = repo_ticket.findAll();
        return ticketModel.stream().map(ticket -> modelMapper.map(ticket, TicketDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public TicketDTO getTicketServicie(Long id) {
        Ticket ticket = repo_ticket.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket no encontrado con ID: " + id));
        return modelMapper.map(ticket, TicketDTO.class);
    }

    @Override
    public TicketDTO postTicketServicie(TicketDTO dto) {
        Cliente cliente = repo_cliente.findById(dto.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + dto.getClienteId()));
        if (cliente.getTickets().isEmpty()) {
            throw new RuntimeException("El cliente no tiene tickets");
        }
        Ticket ticket = new Ticket();
        ticket.setCliente(cliente);
        ticket.setEvento(dto.getEvento());
        ticket.setCosto(dto.getCosto());
        ticket.setFechaVigencia(dto.getFechaVigencia());
        Ticket ticketGuardado = repo_ticket.save(ticket);
        return modelMapper.map(ticketGuardado, TicketDTO.class);
    }

    @Override
    public TicketDTO updateTicketServicie(TicketDTO dto, Long id) {
        Ticket ticket = repo_ticket.findById(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + id));
        ticket.setCosto(dto.getCosto());
        ticket.setEvento(dto.getEvento());
        ticket.setFechaVigencia(dto.getFechaVigencia());
        Ticket actualizado = repo_ticket.save(ticket);
        return modelMapper.map(actualizado, TicketDTO.class);
    }

    @Override
    public void deleteTicketServicie(Long id) {
        Ticket ticket = repo_ticket.findById(id).orElseThrow(() -> new RuntimeException("Ticket no encontrado con ID: " + id));
        repo_ticket.delete(ticket);
    }
}

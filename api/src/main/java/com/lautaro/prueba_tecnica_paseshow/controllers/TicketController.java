package com.lautaro.prueba_tecnica_paseshow.controllers;

import com.lautaro.prueba_tecnica_paseshow.dto.TicketDTO;
import com.lautaro.prueba_tecnica_paseshow.servicies.TicketServicie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    @Autowired
    private TicketServicie ticket_serv;

    @GetMapping
    public ResponseEntity<List<TicketDTO>> getAllTicketsController() {
        List<TicketDTO> tickets = ticket_serv.getAllTicketsServicie();
        if (tickets.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(tickets);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<TicketDTO> getTicketController(@PathVariable Long id) {
        TicketDTO ticket = ticket_serv.getTicketServicie(id);
        return ResponseEntity.ok(ticket);
    }

    @PostMapping
    public ResponseEntity<TicketDTO> postTicketController(@RequestBody TicketDTO dto) {
        TicketDTO newTicket = ticket_serv.postTicketServicie(dto);
        return ResponseEntity.ok(newTicket);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TicketDTO> updateTicketController(@RequestBody TicketDTO dto, @PathVariable Long id) {
        TicketDTO ticketUpdate = ticket_serv.updateTicketServicie(dto, id);
        return ResponseEntity.ok(ticketUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicketController(@PathVariable Long id) {
        ticket_serv.deleteTicketServicie(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

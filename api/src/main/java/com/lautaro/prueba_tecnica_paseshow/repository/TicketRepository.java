package com.lautaro.prueba_tecnica_paseshow.repository;

import com.lautaro.prueba_tecnica_paseshow.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository  extends JpaRepository<Ticket, Long> {
}

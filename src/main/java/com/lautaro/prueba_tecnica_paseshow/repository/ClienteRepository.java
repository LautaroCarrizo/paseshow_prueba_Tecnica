package com.lautaro.prueba_tecnica_paseshow.repository;

import com.lautaro.prueba_tecnica_paseshow.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    boolean existsByDni(String dni);
}

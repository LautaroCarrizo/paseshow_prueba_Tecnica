package com.lautaro.prueba_tecnica_paseshow.servicies;


import com.lautaro.prueba_tecnica_paseshow.dto.ClienteDTO;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ClienteServicie {

    public List<ClienteDTO> getAllClientesServicie();

    public ClienteDTO getClienteServicie(Long id);

    public ClienteDTO postClienteServicie(ClienteDTO dto);

    public ClienteDTO updateClienteServicie(ClienteDTO dto, Long id);

    public void deleteClienteServicie(Long id);
}

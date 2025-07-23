package com.lautaro.prueba_tecnica_paseshow.servicies;


import com.lautaro.prueba_tecnica_paseshow.dto.ClienteDTO;

import java.util.List;

public interface ClienteServicie {

    public List<ClienteDTO> getClientes();

    public ClienteDTO getCliente(Long id);

    public ClienteDTO postCliente(ClienteDTO dto);

    public ClienteDTO updateCliente(ClienteDTO dto, Long id);

    public void deleteCliente();
}

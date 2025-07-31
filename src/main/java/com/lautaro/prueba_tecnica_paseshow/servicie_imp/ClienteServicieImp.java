package com.lautaro.prueba_tecnica_paseshow.servicie_imp;

import com.lautaro.prueba_tecnica_paseshow.dto.ClienteDTO;
import com.lautaro.prueba_tecnica_paseshow.model.Cliente;
import com.lautaro.prueba_tecnica_paseshow.servicies.ClienteServicie;
import com.lautaro.prueba_tecnica_paseshow.repository.ClienteRepository;
import com.lautaro.prueba_tecnica_paseshow.servicies.ClienteValidacionServicie;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServicieImp implements ClienteServicie {
    @Autowired
    private ClienteRepository repo_cliente;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ClienteValidacionServicie validacionExterna;

    @Override
    public List<ClienteDTO> getAllClientesServicie() {
        List<Cliente> clientesModel = repo_cliente.findAll();
        return clientesModel.stream().map(cliente -> modelMapper.map(cliente, ClienteDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ClienteDTO getClienteServicie(Long id) {
        Cliente cliente = repo_cliente.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + id));
        return modelMapper.map(cliente, ClienteDTO.class);

    }

    @Override
    public ClienteDTO postClienteServicie(ClienteDTO dto) {
        if (repo_cliente.existsByDni(dto.getDni())) {
            throw new RuntimeException("Ya existe un cliente con ese dni");
        }
        boolean validado = validacionExterna.validarClienteEndPointPaseshow(dto.getNombre(), dto.getApellido());
        if (!validado) {
            throw new RuntimeException("Cliente rechazado por validacion externa");
        }
        Cliente cliente = modelMapper.map(dto, Cliente.class);
        Cliente clienteGuardado = repo_cliente.save(cliente);
        return modelMapper.map(clienteGuardado, ClienteDTO.class);
    }

    @Override
    public ClienteDTO updateClienteServicie(ClienteDTO dto, Long id) {
        Cliente cliente = repo_cliente.findById(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + id));
        cliente.setNombre(dto.getNombre());
        cliente.setApellido(dto.getApellido());
        cliente.setDni(dto.getDni());
        cliente.setFechaNacimiento(dto.getFechaNacimiento());
        Cliente actualizado = repo_cliente.save(cliente);
        return modelMapper.map(actualizado, ClienteDTO.class);
    }

    @Override
    public void deleteClienteServicie(Long id) {
        Cliente cliente = repo_cliente.findById(id).orElseThrow(() -> new RuntimeException("Cliente no encontrado con ID: " + id));
        repo_cliente.delete(cliente);
    }
}

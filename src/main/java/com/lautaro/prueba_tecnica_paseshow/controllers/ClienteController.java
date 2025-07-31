package com.lautaro.prueba_tecnica_paseshow.controllers;

import com.lautaro.prueba_tecnica_paseshow.dto.ClienteDTO;
import com.lautaro.prueba_tecnica_paseshow.servicies.ClienteServicie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    @Autowired
    private ClienteServicie cliente_serv;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getAllClientesController() {
        List<ClienteDTO> clientes = cliente_serv.getAllClientesServicie();
        if (clientes.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(clientes);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getClienteController(@PathVariable Long id) {
        ClienteDTO cliente = cliente_serv.getClienteServicie(id);
        return ResponseEntity.ok(cliente);
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> postClienteController(@RequestBody ClienteDTO dto) {
        ClienteDTO newCliente = cliente_serv.postClienteServicie(dto);
        return ResponseEntity.ok(newCliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> updateClienteController(@RequestBody ClienteDTO dto, @PathVariable Long id) {
        ClienteDTO clienteUpdate = cliente_serv.updateClienteServicie(dto, id);
        return ResponseEntity.ok(clienteUpdate);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClienteController(@PathVariable Long id) {
        cliente_serv.deleteClienteServicie(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

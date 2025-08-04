package com.lautaro.prueba_tecnica_paseshow.servicie_imp;

import com.lautaro.prueba_tecnica_paseshow.servicies.ClienteValidacionServicie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;


@Service
public class ClienteValidacionExternaImp implements ClienteValidacionServicie {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${validacion.externa.url}")
    private String url;


    @Override
    public boolean validarClienteEndPointPaseshow(String nombre, String apellido) {

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String auth = Base64.getEncoder().encodeToString((nombre + ":" + apellido).getBytes());
        headers.set("Authorization", auth);

        Map<String, String> body = new HashMap<>();
        body.put("nombre", nombre);
        body.put("apellido", apellido);

        HttpEntity<Map<String, String>> request = new HttpEntity<>(body, headers);

        try {
            ResponseEntity<String> response = restTemplate.postForEntity(url, request, String.class);
            return response.getStatusCode() == HttpStatus.OK;
        } catch (Exception e) {
            throw new RuntimeException("No se pudo validar el cliente en el servicio externo");
        }
    }

}

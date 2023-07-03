package com.example.evac02LimayllaHans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/idat")
public class Controller01 {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public ResponseEntity<String> obtenerCodigoNombre() {
        String codigoIDAT = obtenerCodigo();
        String nombreCompleto = obtenerNombreCompleto();
        String resultado = codigoIDAT + " - " + nombreCompleto;
        return new ResponseEntity<>(resultado, HttpStatus.OK);
    }

    @GetMapping("/{subdominio}/codigo")
    public ResponseEntity<String> obtenerCodigo(@PathVariable String subdominio) {
        String codigoIDAT = obtenerCodigo();
        return new ResponseEntity<>(codigoIDAT, HttpStatus.OK);
    }

    @GetMapping("/{subdominio}/nombre-completo")
    public ResponseEntity<String> obtenerNombreCompleto(@PathVariable String subdominio) {
        String nombreCompleto = obtenerNombreCompleto();
        return new ResponseEntity<>(nombreCompleto, HttpStatus.OK);
    }

    private String obtenerCodigo() {
        String url = "https://" + obtenerSubdominio() + ".onrender.com/idat/codigo";
        return restTemplate.getForObject(url, String.class);
    }

    private String obtenerNombreCompleto() {
        String url = "https://" + obtenerSubdominio() + ".onrender.com/idat/nombre-completo";
        return restTemplate.getForObject(url, String.class);
    }

    private String obtenerSubdominio() {
        // Lógica para obtener el subdominio, por ejemplo, desde una base de datos o
        // mediante autenticación del usuario.
        // En este ejemplo, se devuelve un subdominio ficticio "ejemplo123".
        return "ejemplo123";
    }
}

package com.example.evac02LimayllaHans;

import java.lang.String;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(path = "/")
public class Controller {

    @GetMapping(path = "/")
    public String home() {
        return "AT75268140 - HANS LIMAYLLA";
    }

    @GetMapping(path = "/idat/codigo")
    public String idatCod() {
        return "AT75268140";
    }

    @GetMapping(path = "/idat/nombrecompleto")
    public String idatNom() {
        return "hans jefferson limaylla cerron";
    }
}

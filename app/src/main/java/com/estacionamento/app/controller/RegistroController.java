package com.estacionamento.app.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.estacionamento.app.entities.Registro;
import com.estacionamento.app.service.RegistroService;

import reactor.core.publisher.Mono;

@Controller
public class RegistroController {

    private final RegistroService registroService;

    public RegistroController(RegistroService registroService) {
        this.registroService = registroService;
    }

    @QueryMapping
    public Mono<List<Registro>> registros(){
        return (Mono<List<Registro>>) this.registroService.getAllRegistros();
    }

}

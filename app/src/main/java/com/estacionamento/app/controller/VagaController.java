package com.estacionamento.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.estacionamento.app.entities.Vaga;
import com.estacionamento.app.entities.auxiliares.EstadoVaga;
import com.estacionamento.app.service.VagaService;

@Controller
public class VagaController{

    @Autowired
    private VagaService service;

    @QueryMapping
    public List<Vaga> vagas(){
        return service.findAll();
    }

    @QueryMapping
    public Vaga vagaPorId(@Argument Long id){
        return service.findById(id);
    }

    @MutationMapping
    public Vaga criarVaga(@Argument Vaga vaga){
        return service.insert(vaga);
    }

    @MutationMapping
    public Vaga atualizarEstadoVaga(@Argument Long id, @Argument EstadoVaga estadoVaga){
        return service.update(id, estadoVaga);
    }

}

package com.estacionamento.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.estacionamento.app.entities.Estacionamento;
import com.estacionamento.app.service.EstacionamentoService;

@Controller
public class EstacionamentoController {
//dados pessoais está sendo devolvido como null
    @Autowired
    private EstacionamentoService service;

    @QueryMapping
    public List<Estacionamento> estacionamentos(){
        return service.findAll();
    }

    @QueryMapping
    public Estacionamento estacionamentoPorId(@Argument Long id){
        return service.findById(id);
    }

    @QueryMapping
    public Estacionamento atualizarEstacionamento(@Argument Long id){
        return service.findById(id);
    }

    @MutationMapping
    public Estacionamento criarEstacionamento(@Argument Estacionamento Estacionamento){
        return service.insert(Estacionamento);
    }

    @MutationMapping
    public void excluirEstacionamento(@Argument Long id){
        service.delete(id);
    }
}

package com.estacionamento.app.controller;

import java.util.List;

import com.estacionamento.app.dto.EstacionamentoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.estacionamento.app.entities.Estacionamento;
import com.estacionamento.app.service.EstacionamentoService;

@Controller
public class EstacionamentoController {

    private final EstacionamentoService service;

    public EstacionamentoController(EstacionamentoService service) {
        this.service = service;
    }

    @QueryMapping
    public List<EstacionamentoDTO> estacionamentos(){
        return this.service.findAll();
    }

    @QueryMapping
    public EstacionamentoDTO estacionamentoPorId(@Argument Long id){
        return service.findById(id);
    }

    @MutationMapping
    public EstacionamentoDTO atualizarEstacionamento(@Argument EstacionamentoDTO Estacionamento){
        return this.service.insert(Estacionamento);
    }

    @MutationMapping
    public EstacionamentoDTO criarEstacionamento(@Argument EstacionamentoDTO Estacionamento){
        return this.service.insert(Estacionamento);
    }

    @MutationMapping
    public void excluirEstacionamento(@Argument Long id){
        this.service.delete(id);
    }
}

package com.estacionamento.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.estacionamento.app.dto.VagaDTO;
import com.estacionamento.app.entities.auxiliares.EstadoVaga;
import com.estacionamento.app.service.VagaService;

@Controller
public class VagaController{

    @Autowired
    private VagaService service;

    @QueryMapping
    public List<VagaDTO> vagas(){
        return service.findAll();
    }

    @QueryMapping
    public VagaDTO vagaPorId(@Argument Long id){
        return service.findById(id);
    }

    @MutationMapping
    public VagaDTO criarVaga(@Argument VagaDTO vaga){
        return service.insert(vaga);
    }

    @MutationMapping
    public VagaDTO atualizarEstadoVaga(@Argument Long id, @Argument EstadoVaga estadoVaga){
        return service.update(id, estadoVaga);
    }

    @MutationMapping
    public VagaDTO atualizarVaga(@Argument VagaDTO vaga){
        return service.insert(vaga);
    }

    @MutationMapping
    public void excluirVaga(@Argument Long id){
        service.delete(id);
    }

}

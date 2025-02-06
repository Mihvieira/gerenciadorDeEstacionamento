package com.estacionamento.app.controller;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.Arguments;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.estacionamento.app.dto.VagaDTO;
import com.estacionamento.app.entities.auxiliares.EstadoVaga;
import com.estacionamento.app.entities.auxiliares.TipoVeiculo;
import com.estacionamento.app.service.VagaService;

@Controller
public class VagaController{

    private final VagaService service;

    public VagaController(VagaService service) {
        this.service = service;
    }

    @QueryMapping
    public List<VagaDTO> vagas(){
        return this.service.findAll();
    }

    @QueryMapping
    public VagaDTO vagaPorId(@Argument Long id){
        return this.service.findById(id);
    }

    @MutationMapping(name = "criarVaga")
    public VagaDTO criarVaga(@Argument String setor, @Argument TipoVeiculo tipo, @Argument EstadoVaga estadoVaga){
        var vaga = new VagaDTO(setor, tipo, estadoVaga);
        return this.service.insert(vaga);
    }

    @MutationMapping
    public VagaDTO atualizarEstadoVaga(@Arguments Long id, EstadoVaga estadoVaga){
        return this.service.update(id, estadoVaga);
    }

    @MutationMapping
    public VagaDTO atualizarVaga(@Arguments VagaDTO vaga){
        return this.service.insert(vaga);
    }

    @MutationMapping
    public void excluirVaga(@Argument Long id){
        this.service.delete(id);
    }

}

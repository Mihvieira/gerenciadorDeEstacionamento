package com.estacionamento.app.controller;

import java.util.List;

import com.estacionamento.app.dto.EstacionamentoDTO;
import com.estacionamento.app.entities.auxiliares.DadosPessoais;
import com.estacionamento.app.entities.auxiliares.Endereco;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.Arguments;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.estacionamento.app.service.EstacionamentoService;

@Controller
public class EstacionamentoController {

    private final EstacionamentoService service;

    public EstacionamentoController(EstacionamentoService service) {
        this.service = service;
    }

    @QueryMapping
    public List<EstacionamentoDTO> estacionamentos() {
        return this.service.findAll();
    }

    @QueryMapping
    public EstacionamentoDTO estacionamentoPorId(@Argument Long id) {
        return service.findById(id);
    }

    @MutationMapping
    public EstacionamentoDTO criarEstacionamento(@Arguments DadosPessoais dadosEmpresa,
            @Arguments Endereco endereco, @Argument Integer qtdMaxMotos,
            @Argument Integer qtdMaxCarros, @Argument Double precoPorHora) {
        var estacionamento = new EstacionamentoDTO(null, dadosEmpresa, endereco, qtdMaxMotos, qtdMaxCarros, precoPorHora);
        return this.service.insert(estacionamento);
    }

    @MutationMapping
    public EstacionamentoDTO atualizarEstacionamento(@Argument Long id, @Arguments DadosPessoais dadosEmpresa,
    @Arguments Endereco endereco, @Argument Integer qtdMaxMotos,
    @Argument Integer qtdMaxCarros, @Argument Double precoPorHora) {
        var estacionamento = new EstacionamentoDTO(id, dadosEmpresa, endereco, qtdMaxMotos, qtdMaxCarros, precoPorHora);
        return this.service.insert(estacionamento);
    }

    @MutationMapping
    public Boolean excluirEstacionamento(@Argument Long id) {
        this.service.delete(id);
        return true;
    }
}

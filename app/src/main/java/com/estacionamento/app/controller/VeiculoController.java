package com.estacionamento.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.estacionamento.app.dto.VeiculoDTO;
import com.estacionamento.app.entities.auxiliares.TipoVeiculo;
import com.estacionamento.app.service.VeiculoService;

@Controller
public class VeiculoController {
    
    @Autowired
    private VeiculoService service;

    @QueryMapping
    public List<VeiculoDTO> veiculos() {
        return service.findAll();
    }

    @QueryMapping
    public VeiculoDTO veiculoPorId(@Argument Long id) {
        return service.findById(id);
    }

    @QueryMapping
    public VeiculoDTO veiculoPorPlaca(@Argument String placa) {
        return service.findByPlaca(placa);
    }

    @MutationMapping
    public VeiculoDTO criarVeiculo(@Argument TipoVeiculo tipo, @Argument String cor,
            @Argument String placa, @Argument String modelo) {
        var veiculo = new VeiculoDTO(null, tipo, cor, placa, modelo);
        return service.insert(veiculo);
    }

    @MutationMapping
    public VeiculoDTO atualizarVeiculo(@Argument Long id, @Argument TipoVeiculo tipo, @Argument String cor,
            @Argument String placa, @Argument String modelo) {
        var veiculo = new VeiculoDTO(id, tipo, cor, placa, modelo);
        return service.update(veiculo);
    }

    @MutationMapping
    public Boolean excluirVeiculo(@Argument Long id) {
        service.delete(id);
        return true;
    }

}

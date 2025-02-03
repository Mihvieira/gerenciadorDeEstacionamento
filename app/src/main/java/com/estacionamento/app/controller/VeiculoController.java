package com.estacionamento.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.estacionamento.app.entities.Veiculo;
import com.estacionamento.app.service.VeiculoService;

@Controller
public class VeiculoController {

    @Autowired
    private VeiculoService service;

    @QueryMapping
    public List<Veiculo> veiculos(){
        return service.findAll();
    }

    @QueryMapping
    public Veiculo veiculoPorId(@Argument Long id){
        return service.findById(id);
    }

    @QueryMapping
    public Veiculo veiculoPorPlaca(@Argument String placa){
        return service.findByPlaca(placa);
    }

    @MutationMapping
    public Veiculo criarVeiculo(@Argument Veiculo Veiculo){
        return service.insert(Veiculo);
    }

    @MutationMapping
    public Veiculo atualizarEstadoVeiculo(@Argument Veiculo veiculo){
        return service.update(veiculo);
    }
    
    @MutationMapping
    public void excluirVeiculo(@Argument Long id){
        service.delete(id);
    }

}

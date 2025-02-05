package com.estacionamento.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.estacionamento.app.dto.VeiculoDTO;
import com.estacionamento.app.service.VeiculoService;

@Controller
public class VeiculoController {
//veiculo tipo está retornando como nulo
    @Autowired
    private VeiculoService service;

    @QueryMapping
    public List<VeiculoDTO> veiculos(){
        return service.findAll();
    }

    @QueryMapping
    public VeiculoDTO veiculoPorId(@Argument Long id){
        return service.findById(id);
    }

    @QueryMapping
    public VeiculoDTO veiculoPorPlaca(@Argument String placa){
        return service.findByPlaca(placa);
    }

    @MutationMapping
    public VeiculoDTO criarVeiculo(@Argument VeiculoDTO Veiculo){
        return service.insert(Veiculo);
    }

    @MutationMapping
    public VeiculoDTO atualizarVeiculo(@Argument VeiculoDTO veiculo){
        return service.update(veiculo);
    }
    
    @MutationMapping
    public void excluirVeiculo(@Argument Long id){
        service.delete(id);
    }

}

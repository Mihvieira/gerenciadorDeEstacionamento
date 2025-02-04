package com.estacionamento.app.controller;

import java.time.Instant;
import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.estacionamento.app.entities.Registro;
import com.estacionamento.app.service.RegistroService;


@Controller
public class RegistroController{

    private final RegistroService service;

    public RegistroController(RegistroService registroService) {
        this.service = registroService;
    }

    @QueryMapping
    public List<Registro> registros(){
        return service.findAll();
    }

    @QueryMapping
    public Registro registroPorId(@Argument Long id){
        return service.findById(id);
    }

    @QueryMapping
    public Registro registroPorData(@Argument String data){
        return service.findByDate(data);
    }

    @MutationMapping
    public Registro criarRegistro(@Argument Registro Registro){
        return service.insert(Registro);
    }

    @MutationMapping
    public Registro atualizarRegistro(@Argument Long id, @Argument Instant saida){
        return service.update(id, saida);
    }
    
    @MutationMapping
    public void excluirRegistro(@Argument Long id){
        service.delete(id);
    }

}

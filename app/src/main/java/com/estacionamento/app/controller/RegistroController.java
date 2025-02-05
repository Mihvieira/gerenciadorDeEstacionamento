package com.estacionamento.app.controller;

import java.time.Instant;
import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.estacionamento.app.dto.RegistroDTO;
import com.estacionamento.app.service.RegistroService;


@Controller
public class RegistroController{

    private final RegistroService service;

    public RegistroController(RegistroService registroService) {
        this.service = registroService;
    }

    @QueryMapping
    public List<RegistroDTO> registros(){
        return service.findAll();
    }

    @QueryMapping
    public RegistroDTO registroPorId(@Argument Long id){
        return service.findById(id);
    }

    @QueryMapping
    public RegistroDTO registroPorData(@Argument String data){
        return service.findByDate(data);
    }

    @MutationMapping
    public RegistroDTO criarRegistro(@Argument RegistroDTO Registro){
        return service.insert(Registro);
    }

    @MutationMapping
    public RegistroDTO incluirSaidaRegistro(@Argument Long id, @Argument Instant saida){
        return service.update(id, saida);
    }

    @MutationMapping
    public RegistroDTO atualizarRegistro(@Argument RegistroDTO Registro){
        return service.insert(Registro);
    }

    @MutationMapping
    public void excluirRegistro(@Argument Long id){
        this.service.delete(id);;
    }

}

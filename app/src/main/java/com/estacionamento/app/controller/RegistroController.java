package com.estacionamento.app.controller;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.estacionamento.app.dto.RegistroDTO;
import com.estacionamento.app.service.RegistroService;


@Controller
public class RegistroController{

    @Autowired
    private RegistroService service;

    @QueryMapping
    public List<RegistroDTO> registros(){
        return this.service.findAll();
    }

    @QueryMapping
    public RegistroDTO registroPorId(@Argument Long id){
        return this.service.findById(id);
    }

    @QueryMapping
    public RegistroDTO registroPorData(@Argument String data){
        return this.service.findByDate(data);
    }

    @MutationMapping
    public RegistroDTO criarRegistro(@Argument RegistroDTO Registro){
        return this.service.insert(Registro);
    }

    @MutationMapping
    public RegistroDTO incluirSaidaRegistro(@Argument Long id, @Argument Instant saida){
        return this.service.update(id, saida);
    }

    @MutationMapping
    public RegistroDTO atualizarRegistro(@Argument RegistroDTO Registro){
        return this.service.insert(Registro);
    }

    @MutationMapping
    public void excluirRegistro(@Argument Long id){
        this.service.delete(id);;
    }

}

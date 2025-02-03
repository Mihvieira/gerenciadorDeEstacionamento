package com.estacionamento.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.estacionamento.app.entities.Empresa;
import com.estacionamento.app.service.EmpresaService;

@Controller
public class EmpresaController {

    @Autowired
    private EmpresaService service;

    @QueryMapping
    public List<Empresa> empresas(){
        return service.findAll();
    }

    @QueryMapping
    public Empresa empresaPorId(@Argument Long id){
        return service.findById(id);
    }

    @MutationMapping
    public Empresa criarEmpresa(@Argument Empresa Empresa){
        return service.insert(Empresa);
    }

    @MutationMapping
    public Empresa atualizarEstadoEmpresa(@Argument Empresa empresa){
        return service.update(empresa);
    }

}

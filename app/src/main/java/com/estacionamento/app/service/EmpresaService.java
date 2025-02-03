package com.estacionamento.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estacionamento.app.entities.Empresa;
import com.estacionamento.app.repository.EmpresaRepository;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository repository;

    public List<Empresa> findAll(){
        return repository.findAll();
    }

    public Empresa insert(Empresa Empresa) {
        return repository.save(Empresa);
    }

    public Empresa findById(Long id) {
        return repository.findById(id).get();
    }

    public Empresa update(Empresa empresa) {
        return insert(empresa);
    }

}

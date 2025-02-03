package com.estacionamento.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estacionamento.app.entities.Vaga;
import com.estacionamento.app.entities.auxiliares.EstadoVaga;
import com.estacionamento.app.repository.VagaRepository;

@Service
public class VagaService {

    @Autowired
    private VagaRepository repository;

    public List<Vaga> findAll(){
        return repository.findAll();
    }

    public Vaga insert(Vaga vaga) {
        return repository.save(vaga);
    }

    public Vaga findById(Long id) {
        return repository.findById(id).get();
    }

    public Vaga update(Long id, EstadoVaga estadoVaga) {
        Vaga vaga = repository.findById(id).get();
        vaga.setEstadoVaga(estadoVaga);
        return insert(vaga);
    }

}

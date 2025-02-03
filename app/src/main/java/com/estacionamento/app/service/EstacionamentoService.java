package com.estacionamento.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estacionamento.app.entities.Estacionamento;
import com.estacionamento.app.repository.EstacionamentoRepository;

@Service
public class EstacionamentoService {

    @Autowired
    private EstacionamentoRepository repository;

    public List<Estacionamento> findAll(){
        return repository.findAll();
    }

    public Estacionamento insert(Estacionamento Estacionamento) {
        return repository.save(Estacionamento);
    }

    public Estacionamento findById(Long id) {
        return repository.findById(id).get();
    }

    public Estacionamento update(Estacionamento estacionamento) {
        return insert(estacionamento);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

}

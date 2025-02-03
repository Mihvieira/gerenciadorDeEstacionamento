package com.estacionamento.app.service;

import java.time.Instant;
import java.util.List;

import org.springframework.stereotype.Service;

import com.estacionamento.app.entities.Registro;
import com.estacionamento.app.repository.RegistroRepository;

@Service
public class RegistroService {

    private final RegistroRepository repository;

    public RegistroService(RegistroRepository registroRepository){
        this.repository = registroRepository;
    }

    public List<Registro> findAll(){
        return repository.findAll();
    }

    public Registro insert(Registro Registro) {
        return repository.save(Registro);
    }

    public Registro findById(Long id) {
        return repository.findById(id).get();
    }

    public Registro update(Long id, Instant saida) {
        Registro Registro = repository.findById(id).get();
        Registro.setSaida(saida);;
        return insert(Registro);
    }

}

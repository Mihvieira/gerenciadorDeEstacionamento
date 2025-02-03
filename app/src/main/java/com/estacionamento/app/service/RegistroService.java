package com.estacionamento.app.service;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estacionamento.app.entities.Registro;
import com.estacionamento.app.entities.Vaga;
import com.estacionamento.app.entities.auxiliares.EstadoVaga;
import com.estacionamento.app.repository.RegistroRepository;

@Service
public class RegistroService {

    private final RegistroRepository repository;
    @Autowired
    private VagaService vagaService;

    public RegistroService(RegistroRepository registroRepository){
        this.repository = registroRepository;
    }

    public List<Registro> findAll(){
        return repository.findAll();
    }

    public Registro insert(Registro registro) {
        Vaga vaga = registro.getVaga();
        vaga.setEstadoVaga(EstadoVaga.Ocupada);
        return repository.save(registro);
    }

    public Registro findById(Long id) {
        return repository.findById(id).get();
    }

    public Registro update(Long id, Instant saida) {
        Registro registro = repository.findById(id).get();
        registro.setSaida(saida);
        Vaga vaga = registro.getVaga();
        vaga.setEstadoVaga(EstadoVaga.Desocupada);
        vagaService.insert(vaga);
        return insert(registro);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

}

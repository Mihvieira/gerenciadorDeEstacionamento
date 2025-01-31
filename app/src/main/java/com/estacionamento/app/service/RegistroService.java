package com.estacionamento.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.estacionamento.app.entities.Registro;
import com.estacionamento.app.repository.RegistroRepository;

@Service
public class RegistroService {

    private final RegistroRepository registroRepository;

    public RegistroService(RegistroRepository registroRepository){
        this.registroRepository = registroRepository;
    }

    public List<Registro> getAllRegistros(){
        return registroRepository.findAll();
    }

}

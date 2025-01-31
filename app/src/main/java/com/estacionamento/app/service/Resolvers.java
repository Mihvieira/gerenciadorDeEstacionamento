package com.estacionamento.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.estacionamento.app.entities.Vaga;
import com.estacionamento.app.repository.EmpresaRepository;
import com.estacionamento.app.repository.EstacionamentoRepository;
import com.estacionamento.app.repository.RegistroRepository;
import com.estacionamento.app.repository.VagaRepository;
import com.estacionamento.app.repository.VeiculoRepository;

public class Resolvers {

    @Autowired
    private VagaRepository vagaRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private RegistroRepository registroRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private EstacionamentoRepository estacionamentoRepository;

    public List<Vaga> vagas() {
        return vagaRepository.findAll();
    }

    public Vaga vagaPorId(Long id) {
        return vagaRepository.findById(id).orElse(null);
    }

}

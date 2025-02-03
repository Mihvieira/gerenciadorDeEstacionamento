package com.estacionamento.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estacionamento.app.entities.Veiculo;
import com.estacionamento.app.repository.VeiculoRepository;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository repository;

    public List<Veiculo> findAll(){
        return repository.findAll();
    }

    public Veiculo insert(Veiculo Veiculo) {
        return repository.save(Veiculo);
    }

    public Veiculo findById(Long id) {
        return repository.findById(id).get();
    }

    public Veiculo findByPlaca(String placa) {
        return repository.findByPlaca(placa).get();
    }

    public Veiculo update(Veiculo veiculo) {
        return insert(veiculo);
    }

}

package com.estacionamento.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;

import com.estacionamento.app.dto.VagaDTO;
import com.estacionamento.app.entities.Vaga;
import com.estacionamento.app.entities.auxiliares.EstadoVaga;
import com.estacionamento.app.entities.auxiliares.TipoVeiculo;
import com.estacionamento.app.repository.VagaRepository;
import com.estacionamento.app.service.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class VagaService {

    @Autowired
    private VagaRepository repository;

    public List<VagaDTO> findAll() {
        List<Vaga> entity = repository.findAll();
        return entity.stream().map(VagaDTO::new).collect(Collectors.toList());
    }

    public VagaDTO findById(Long id) {
        Vaga entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        return new VagaDTO(entity);
    }

    public List<VagaDTO> findVagasPorEstadoTipo(EstadoVaga estadoVaga, TipoVeiculo tipo){
        List<Vaga> entity = repository.findVagasPorEstadoTipo(estadoVaga, tipo);
        return entity.stream().map(VagaDTO::new).collect(Collectors.toList());
    }

    @Transactional
    public VagaDTO insert(VagaDTO obj) {
        try {
            Vaga entity = new Vaga();
            if (obj.getId() != null) {
                entity.setId(obj.getId());
                entity.setEstadoVaga(obj.getEstadoVaga());
            }
            entity.setSetor(obj.getSetor());
            entity.setTipo(obj.getTipo());
            Vaga savedEntity = repository.save(entity);
            return new VagaDTO(savedEntity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(obj.getId());
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(e.getMessage());
        } catch (HttpMessageNotReadableException e) {
            throw new RuntimeException(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error: " + e.getMessage());
        }
    }

    public VagaDTO update(Long id, EstadoVaga estadoVaga) {
        Vaga vaga = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        vaga.setEstadoVaga(estadoVaga);
        return insert(new VagaDTO(vaga));
    }

    @Transactional
    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error: " + e.getMessage());
        }

    }

}

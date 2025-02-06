package com.estacionamento.app.service;

import java.util.List;
import java.util.stream.Collectors;

import com.estacionamento.app.dto.EstacionamentoDTO;
import com.estacionamento.app.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;

import com.estacionamento.app.entities.Estacionamento;
import com.estacionamento.app.repository.EstacionamentoRepository;

@Service
public class EstacionamentoService {

    @Autowired
    private EstacionamentoRepository repository;

    public List<EstacionamentoDTO> findAll(){
        List<Estacionamento> entity = repository.findAll();
        return entity.stream().map(EstacionamentoDTO::new).collect(Collectors.toList());
    }

    public EstacionamentoDTO findById(Long id) {
        Estacionamento entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        return new EstacionamentoDTO(entity);
    }

    @Transactional
    public EstacionamentoDTO insert(EstacionamentoDTO obj) {
        try {
            Estacionamento entity = new Estacionamento();
            if (obj.getId() != null) {
                entity.setId(obj.getId());
            }
            entity.setDadosEmpresa(obj.getDadosEmpresa());
            entity.setQtdMaxCarros(obj.getQtdMaxCarros());
            entity.setQtdMaxMotos(obj.getQtdMaxMotos());
            var savedEntity = repository.save(entity);
            return new EstacionamentoDTO(savedEntity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(obj.getId());
        } catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException(e.getMessage());
        }catch (HttpMessageNotReadableException e){
            throw new RuntimeException(e.getMessage());
        }catch (Exception e) {
            throw new RuntimeException("Unexpected error: " + e.getMessage());
        }
    }

    public EstacionamentoDTO update(EstacionamentoDTO entity) {
        return insert(entity);
    }

    @Transactional
    public void delete(Long id){
        repository.deleteById(id);
    }

}

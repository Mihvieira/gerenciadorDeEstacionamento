package com.estacionamento.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;

import com.estacionamento.app.dto.VeiculoDTO;
import com.estacionamento.app.entities.Veiculo;
import com.estacionamento.app.repository.VeiculoRepository;
import com.estacionamento.app.service.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository repository;

    public List<VeiculoDTO> findAll() {
        List<Veiculo> entities = repository.findAll();
        return entities.stream().map(VeiculoDTO::new).collect(Collectors.toList());
    }

    public VeiculoDTO findById(Long id) {
        Veiculo entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        System.out.println(entity);
        return new VeiculoDTO(entity);
    }

    @Transactional
    public VeiculoDTO insert(VeiculoDTO obj) {
        try {
            Veiculo entity = new Veiculo();
            if (obj.getId() != null) {
                entity.setId(obj.getId());
            }
            entity.setCor(obj.getCor());
            entity.setModelo(obj.getModelo());
            entity.setPlaca(obj.getPlaca());
            entity.setTipo(obj.getTipo());
            Veiculo savedEntity = repository.save(entity);
            return new VeiculoDTO(savedEntity);
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

    public VeiculoDTO update(VeiculoDTO obj) {
        Veiculo Veiculo = repository.findById(obj.getId())
                .orElseThrow(() -> new ResourceNotFoundException(obj.getId()));
        return insert(new VeiculoDTO(Veiculo));
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

    public VeiculoDTO findByPlaca(String placa) {
        Veiculo Veiculo = repository.findByPlaca(placa).get();
        return new VeiculoDTO(Veiculo);
    }

}

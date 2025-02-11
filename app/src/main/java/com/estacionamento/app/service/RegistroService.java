package com.estacionamento.app.service;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

import com.estacionamento.app.dto.RegistroDTO;
import com.estacionamento.app.entities.Veiculo;
import com.estacionamento.app.entities.auxiliares.EstadoVaga;
import com.estacionamento.app.repository.VagaRepository;
import com.estacionamento.app.repository.VeiculoRepository;
import com.estacionamento.app.service.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Service;

import com.estacionamento.app.entities.Registro;
import com.estacionamento.app.entities.Vaga;
import com.estacionamento.app.repository.RegistroRepository;

@Service
public class RegistroService {

    private final RegistroRepository repository;
    @Autowired
    private VagaRepository vagaRepository;
    @Autowired
    private VeiculoRepository veiculoRepository;

    public RegistroService(RegistroRepository registroRepository) {
        this.repository = registroRepository;
    }

    public List<RegistroDTO> findAll() {
        List<Registro> entity = repository.findAll();
        return entity.stream().map(RegistroDTO::new).collect(Collectors.toList());
    }

    public RegistroDTO findById(Long id) {
        Registro entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        return new RegistroDTO(entity);
    }

    public RegistroDTO findByDate(String data) {
        Registro entity = repository.findByDate(data)
                .orElseThrow(() -> new ResourceNotFoundException(data));
        return new RegistroDTO(entity);
    }

    @Transactional
    public RegistroDTO insert(RegistroDTO obj) {
        try {
            Registro entity = new Registro();
            Vaga vaga = vagaRepository.findById(obj.getVaga_id())
                    .orElseThrow(() -> new ResourceNotFoundException(obj.getVaga_id()));
            Veiculo veiculo = veiculoRepository.findById(obj.getVeiculo_id())
                    .orElseThrow(() -> new ResourceNotFoundException(obj.getVeiculo_id()));
            Double price = vaga.getEstacionamento().getprecoPorHora();
            if (obj.getId() != null) {
                entity.setId(obj.getId());
            }
            if (obj.getSaida() != null) {
                entity.setEntrada(obj.getEntrada());
                entity.setSaida(obj.getSaida());
                entity.setValorTotal(calcPreco(price, entity.getTempo()));
                vaga.setEstadoVaga(EstadoVaga.DESOCUPADA);
                vagaRepository.save(vaga);
            }
            entity.setVaga(vaga);
            entity.setVeiculo(veiculo);
            entity.setEntrada(obj.getEntrada());
            Registro savedEntity = repository.save(entity);
            return new RegistroDTO(savedEntity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(obj.getId());
        } catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException(e.getMessage());
        } catch (HttpMessageNotReadableException e) {
            throw new RuntimeException(e.getMessage());
        } catch (NullPointerException e) {
            e.printStackTrace();
            throw new NullPointerException(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error: " + e.getMessage());
        }
    }

    public RegistroDTO incluirSaida(Long id, OffsetDateTime saida) {
        Registro entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        entity.setSaida(saida);
        return insert(new RegistroDTO(entity));
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

    public static Double calcPreco(Double price, Duration tempo) {
        if (price == null || tempo == null) {
            throw new IllegalArgumentException("Price and duration must not be null");
        }
        long minutes = tempo.toMinutes();
        double valorTotal = (price / 60) * minutes;
        return Math.round(valorTotal * 100.0) / 100.0;
    }

}

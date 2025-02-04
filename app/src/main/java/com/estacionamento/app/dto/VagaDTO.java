package com.estacionamento.app.dto;

import java.io.Serializable;

import com.estacionamento.app.entities.Vaga;
import com.estacionamento.app.entities.auxiliares.EstadoVaga;
import com.estacionamento.app.entities.auxiliares.TipoVeiculo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class VagaDTO implements Serializable{
    private static final Long serialVersionUID = 1L;

    private Long id;
    private String setor;
    private TipoVeiculo tipoVaga;
    private EstadoVaga estadoVaga;
    
    public VagaDTO() {
    }

    public VagaDTO(Vaga vaga) {
        this.id = vaga.getId();
        this.setor = vaga.getSetor();
<<<<<<< HEAD
        this.tipoVaga = vaga.getTipoVeiculo();
=======
        this.tipoVaga = vaga.getTipoVaga();
>>>>>>> 71cb4fd (adiciona exceção ResourceNotFoundException; renomeia enums para uso de constantes em maiúsculas; ajusta estado padrão da vaga; atualiza controladores e serviços para usar DTOs;)
        this.estadoVaga = vaga.getEstadoVaga();
    }

    public VagaDTO(String setor, TipoVeiculo tipoVaga, EstadoVaga estadoVaga) {
        this.setor = setor;
        this.tipoVaga = tipoVaga;
        this.estadoVaga = estadoVaga;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public TipoVeiculo getTipoVaga() {
        return tipoVaga;
    }

    public void setTipoVaga(TipoVeiculo tipoVaga) {
        this.tipoVaga = tipoVaga;
    }

    public EstadoVaga getEstadoVaga() {
        return estadoVaga;
    }

    public void setEstadoVaga(EstadoVaga estadoVaga) {
        this.estadoVaga = estadoVaga;
    }

    
    
}
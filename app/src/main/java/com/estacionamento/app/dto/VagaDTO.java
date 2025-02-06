package com.estacionamento.app.dto;

import java.io.Serial;
import java.io.Serializable;

import com.estacionamento.app.entities.Vaga;
import com.estacionamento.app.entities.auxiliares.EstadoVaga;
import com.estacionamento.app.entities.auxiliares.TipoVeiculo;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class VagaDTO implements Serializable{
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String setor;
    private TipoVeiculo tipo;
    private EstadoVaga estadoVaga;

    public VagaDTO(Vaga vaga) {
        this.id = vaga.getId();
        this.setor = vaga.getSetor();
        this.tipo = vaga.getTipo();
        this.estadoVaga = vaga.getEstadoVaga();
    }

    public VagaDTO(String setor, TipoVeiculo tipoVaga, EstadoVaga estadoVaga) {
        this.setor = setor;
        this.tipo = tipoVaga;
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

    public TipoVeiculo getTipo() {
        return tipo;
    }

    public void setTipo(TipoVeiculo tipo) {
        this.tipo = tipo;
    }

    public EstadoVaga getEstadoVaga() {
        return estadoVaga;
    }

    public void setEstadoVaga(EstadoVaga estadoVaga) {
        this.estadoVaga = estadoVaga;
    }

    
    
}
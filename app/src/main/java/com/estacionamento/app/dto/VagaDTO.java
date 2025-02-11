package com.estacionamento.app.dto;

import java.io.Serial;
import java.io.Serializable;

import com.estacionamento.app.entities.Vaga;
import com.estacionamento.app.entities.auxiliares.EstadoVaga;
import com.estacionamento.app.entities.auxiliares.TipoVeiculo;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class VagaDTO implements Serializable{
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String setor;
    private TipoVeiculo tipo;
    private EstadoVaga estadoVaga;
    private Long estacionamento_id;

    public VagaDTO(Vaga vaga) {
        this.id = vaga.getId();
        this.setor = vaga.getSetor();
        this.tipo = vaga.getTipo();
        this.estadoVaga = vaga.getEstadoVaga();
        this.estacionamento_id = vaga.getEstacionamento().getId();
    }

    public VagaDTO(String setor, TipoVeiculo tipoVaga, EstadoVaga estadoVaga, Long estacionamento_Id) {
        this.setor = setor;
        this.tipo = tipoVaga;
        this.estadoVaga = estadoVaga;
        this.estacionamento_id = estacionamento_Id;
    }
    
    
}
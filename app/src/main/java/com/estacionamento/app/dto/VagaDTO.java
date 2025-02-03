package com.estacionamento.app.dto;

import com.estacionamento.app.entities.Estacionamento;
import com.estacionamento.app.entities.auxiliares.EstadoVaga;
import com.estacionamento.app.entities.auxiliares.TipoVeiculo;

public record VagaDTO(
    Long id,
    String setor, 
    TipoVeiculo tipoVaga,
    EstadoVaga estadoVaga,
    Estacionamento estacionamento
) {
} 
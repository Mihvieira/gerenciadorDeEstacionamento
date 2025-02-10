package com.estacionamento.app.dto;

import java.io.Serial;
import java.io.Serializable;
import java.time.Duration;
import java.time.OffsetDateTime;

import com.estacionamento.app.entities.Registro;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
public class RegistroDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long vaga_id;
    private Long veiculo_id;
    private OffsetDateTime entrada;
    private OffsetDateTime saida;
    private Duration tempo;
    private Double valorTotal;

    public RegistroDTO(Long vaga_id, Long veiculo_id, OffsetDateTime entrada, OffsetDateTime saida) {
        this.vaga_id = vaga_id;
        this.veiculo_id = veiculo_id;
        this.entrada = entrada;
        this.saida = saida;
    }

    public RegistroDTO(Long vaga_id, Long veiculo_id, OffsetDateTime entrada) {
        this.vaga_id = vaga_id;
        this.veiculo_id = veiculo_id;
        this.entrada = entrada;
    }

    public RegistroDTO(Registro obj) {
        setId(obj.getId());
        setEntrada(obj.getEntrada());
        setVaga_id(obj.getVaga().getId());
        setVeiculo_id(obj.getVeiculo().getId());
        setSaida(obj.getSaida());
        setTempo(obj.getTempo());
        setValorTotal(obj.getValorTotal());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVaga_id() {
        return vaga_id;
    }

    public void setVaga_id(Long vaga_id) {
        this.vaga_id = vaga_id;
    }

    public Long getVeiculo_id() {
        return veiculo_id;
    }

    public void setVeiculo_id(Long veiculo_id) {
        this.veiculo_id = veiculo_id;
    }

    public OffsetDateTime getEntrada() {
        return entrada;
    }

    public void setEntrada(OffsetDateTime entrada) {
        this.entrada = entrada;
    }

    public OffsetDateTime getSaida() {
        return saida;
    }

    public void setSaida(OffsetDateTime saida) {
        this.saida = saida;
    }

    public Duration getTempo() {
        return tempo;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setTempo(Duration tempo) {
        this.tempo = tempo;
    }


}

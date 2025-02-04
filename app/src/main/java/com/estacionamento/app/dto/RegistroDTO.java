package com.estacionamento.app.dto;

import java.io.Serializable;
import java.time.Instant;

import com.estacionamento.app.entities.Registro;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class RegistroDTO implements Serializable{
    private static final Long serialVersionUID = 1L;

    Long id;
    private Long vaga_id;
    private Long veiculo_id;
    private Instant entrada;
    private Instant saida;


    public RegistroDTO(Registro obj) {
        setId(obj.getId());
        setEntrada(obj.getEntrada());
        setVaga_id(obj.getVaga().getId());
        setVeiculo_id(obj.getVeiculo().getId());
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
    public Instant getEntrada() {
        return entrada;
    }
    public void setEntrada(Instant entrada) {
        this.entrada = entrada;
    }
    public Instant getSaida() {
        return saida;
    }
    public void setSaida(Instant saida) {
        this.saida = saida;
    }

    
}

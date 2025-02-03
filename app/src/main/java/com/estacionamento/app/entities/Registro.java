package com.estacionamento.app.entities;

import java.io.Serializable;
import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_registro")
public class Registro implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @ManyToOne
    @JoinColumn(name = "vaga_id")
    private Vaga vaga;
    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    private Veiculo veiculo;
    private Instant entrada;
    private Instant saida;
    
    public Registro() {
    }

    public Registro(Long id, Vaga vaga, Veiculo veiculo, Instant entrada, Instant saida) {
        this.id = id;
        this.vaga = vaga;
        this.veiculo = veiculo;
        this.entrada = entrada;
        this.saida = saida;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Registro other = (Registro) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Registro [id=" + id + ", entrada=" + entrada + ", saida=" + saida + "]";
    }

    
}

package com.estacionamento.app.entities;

import java.io.Serial;
import java.io.Serializable;
import java.time.Duration;
import java.time.OffsetDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "tb_registro")
@AllArgsConstructor
public class Registro implements Serializable{
    @Serial
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
    @NotNull
    private OffsetDateTime entrada;
    private OffsetDateTime saida;
    private Duration tempo;
    private Double valorTotal;
    
    public Registro() {
    }

    public Registro(Vaga vaga, Veiculo veiculo, OffsetDateTime entrada) {
        this.vaga = vaga;
        this.veiculo = veiculo;
        this.entrada = entrada;
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
        return this.tempo = Duration.between(entrada, saida);
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
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
        return "Registro [id=" + id + ", vaga=" + vaga + ", veiculo=" + veiculo + ", entrada=" + entrada + ", saida="
                + saida + ", tempo=" + tempo + ", valorTotal=" + valorTotal + "]";
    }

    
}

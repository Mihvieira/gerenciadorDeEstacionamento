package com.estacionamento.app.entities.pk;

import java.io.Serializable;

import com.estacionamento.app.entities.Vaga;
import com.estacionamento.app.entities.Veiculo;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class RegistroPK implements Serializable{
    private static final Long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "vaga_id")
    private Vaga vaga;
    @ManyToOne
    @JoinColumn(name = "veiculo_id")
    private Veiculo veiculo;

    public RegistroPK() {
    }

    public RegistroPK(Vaga vaga, Veiculo veiculo) {
        this.vaga = vaga;
        this.veiculo = veiculo;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((vaga == null) ? 0 : vaga.hashCode());
        result = prime * result + ((veiculo == null) ? 0 : veiculo.hashCode());
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
        RegistroPK other = (RegistroPK) obj;
        if (vaga == null) {
            if (other.vaga != null)
                return false;
        } else if (!vaga.equals(other.vaga))
            return false;
        if (veiculo == null) {
            if (other.veiculo != null)
                return false;
        } else if (!veiculo.equals(other.veiculo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "RegistroPK [vaga=" + vaga + ", veiculo=" + veiculo + "]";
    }

}

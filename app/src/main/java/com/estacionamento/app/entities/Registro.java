package com.estacionamento.app.entities;

import java.io.Serializable;
import java.time.Instant;

import com.estacionamento.app.entities.pk.RegistroPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_registro")
public class Registro implements Serializable{
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private RegistroPK id = new RegistroPK();
    private Instant entrada;
    private Instant saida;
    
    public Registro() {
    }

    public Registro(Vaga vaga, Veiculo veiculo, Instant entrada) {
        this.id.setVaga(vaga);
        this.id.setVeiculo(veiculo);
        this.entrada = entrada;
    }

    public RegistroPK getId() {
        return id;
    }

    public void setId(RegistroPK id) {
        this.id = id;
    }
    
    public Vaga getVaga(){
        return this.id.getVaga();
    }

    public Veiculo getVeiculo(){
        return this.id.getVeiculo();
    }

    public void setVaga(Vaga vaga){
        this.id.setVaga(vaga);
    }

    public void setVeiculo(Veiculo veiculo){
        this.id.setVeiculo(veiculo);
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

package com.estacionamento.app.entities;

import java.util.HashSet;
import java.util.Set;

import com.estacionamento.app.entities.auxiliares.DadosPessoais;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_empresa")
public class Empresa {

    Long id;
    private DadosPessoais dadosEmpresa;
    @OneToOne(mappedBy = "id.empresa")
    private Set<Estacionamento> estacionamento = new HashSet<>();

    public Empresa() {
    }

    public Empresa(Long id, DadosPessoais dadosEmpresa, Estacionamento estacionamento) {
        this.id = id;
        this.dadosEmpresa = dadosEmpresa;
        this.estacionamento.add(estacionamento);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DadosPessoais getDadosEmpresa() {
        return dadosEmpresa;
    }

    public void setDadosEmpresa(DadosPessoais dadosEmpresa) {
        this.dadosEmpresa = dadosEmpresa;
    }

    public Set<Estacionamento> getEstacionamento() {
        return estacionamento;
    }

    public void setEstacionamento(Estacionamento estacionamento) {
        this.estacionamento.add(estacionamento);
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
        Empresa other = (Empresa) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Empresa [id=" + id + ", dadosEmpresa=" + dadosEmpresa + ", estacionamento=" + estacionamento + "]";
    }

    

}

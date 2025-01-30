package com.estacionamento.app.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_estacionamento")
public class Estacionamento implements Serializable{
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "estacionamento", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Vaga> vagas;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

    private Integer quantidadeMaxMotos;
    private Integer quantidadeMaxCarros;
    
    public Estacionamento() {
    }

    public Estacionamento(Long id, Set<Vaga> vagas, Integer quantidadeMaxMotos, Integer quantidadeMaxCarros, Empresa empresa) {
        this.id = id;
        this.vagas = vagas;
        this.quantidadeMaxMotos = quantidadeMaxMotos;
        this.quantidadeMaxCarros = quantidadeMaxCarros;
        this.empresa= empresa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Vaga> getVagas() {
        return vagas;
    }

    public void setVagas(Set<Vaga> vagas) {
        this.vagas = vagas;
    }

    public Integer getQuantidadeMaxMotos() {
        return quantidadeMaxMotos;
    }

    public void setQuantidadeMaxMotos(Integer quantidadeMaxMotos) {
        this.quantidadeMaxMotos = quantidadeMaxMotos;
    }

    public Integer getQuantidadeMaxCarros() {
        return quantidadeMaxCarros;
    }

    public void setQuantidadeMaxCarros(Integer quantidadeMaxCarros) {
        this.quantidadeMaxCarros = quantidadeMaxCarros;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
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
        Estacionamento other = (Estacionamento) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Estacionamento [id=" + id + ", vaga=" + vagas + ", quantidadeMaxMotos="
                + quantidadeMaxMotos + ", quantidadeMaxCarros=" + quantidadeMaxCarros + "]";
    }


}

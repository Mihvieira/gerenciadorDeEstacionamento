package com.estacionamento.app.entities;

import java.io.Serializable;
import java.util.Set;

import com.estacionamento.app.entities.auxiliares.DadosPessoais;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_empresa")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Empresa implements Serializable{
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Embedded
    private DadosPessoais dadosEmpresa;
    @OneToMany(mappedBy = "empresa")
    private Set<Estacionamento> estacionamento;

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

    

    public void setEstacionamento(Set<Estacionamento> estacionamento) {
        this.estacionamento = estacionamento;
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

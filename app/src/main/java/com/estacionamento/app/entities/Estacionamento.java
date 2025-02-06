package com.estacionamento.app.entities;

import java.io.Serial;
import java.io.Serializable;
import com.estacionamento.app.entities.auxiliares.DadosPessoais;
import com.estacionamento.app.entities.auxiliares.Endereco;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_estacionamento")
@NoArgsConstructor
@AllArgsConstructor
public class Estacionamento implements Serializable{
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private DadosPessoais dadosEmpresa;
    @Embedded
    private Endereco endereco;
    private Integer qtdMaxMotos;
    private Integer qtdMaxCarros;


    public Estacionamento(DadosPessoais dadosEmpresa, Endereco endereco, Integer qtdMaxMotos, Integer qtdMaxCarros) {
        this.dadosEmpresa = dadosEmpresa;
        this.endereco = endereco;
        this.qtdMaxMotos = qtdMaxMotos;
        this.qtdMaxCarros = qtdMaxCarros;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQtdMaxMotos() {
        return qtdMaxMotos;
    }

    public void setQtdMaxMotos(Integer quantidadeMaxMotos) {
        this.qtdMaxMotos = quantidadeMaxMotos;
    }

    public Integer getQtdMaxCarros() {
        return qtdMaxCarros;
    }

    public void setQtdMaxCarros(Integer quantidadeMaxCarros) {
        this.qtdMaxCarros = quantidadeMaxCarros;
    }

    public DadosPessoais getDadosEmpresa() {
        return dadosEmpresa;
    }

    public void setDadosEmpresa(DadosPessoais dadosEmpresa) {
        this.dadosEmpresa = dadosEmpresa;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
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
        return "Estacionamento [id=" + id + ", quantidadeMaxMotos="
                + qtdMaxMotos + ", quantidadeMaxCarros=" + qtdMaxCarros + "]";
    }


}

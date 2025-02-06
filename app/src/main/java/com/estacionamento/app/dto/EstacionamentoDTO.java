package com.estacionamento.app.dto;

import java.io.Serial;
import java.io.Serializable;

import com.estacionamento.app.entities.Estacionamento;
import com.estacionamento.app.entities.auxiliares.DadosPessoais;
import com.estacionamento.app.entities.auxiliares.Endereco;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class EstacionamentoDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private DadosPessoais dadosEmpresa;
    private Endereco endereco;
    private Integer qtdMaxMotos;
    private Integer qtdMaxCarros;


    public EstacionamentoDTO(Long id, DadosPessoais dadosEmpresa, Endereco endereco, Integer qtdMaxMotos,
            Integer qtdMaxCarros) {
        if (id !=null) {
            this.id = id;
        }
        this.dadosEmpresa = dadosEmpresa;
        this.endereco = endereco;
        this.qtdMaxMotos = qtdMaxMotos;
        this.qtdMaxCarros = qtdMaxCarros;
    }

    public EstacionamentoDTO(Estacionamento obj) {
        if (obj.getId() != null) {
            setId(obj.getId());
        }
        setQtdMaxCarros(obj.getQtdMaxCarros());
        setQtdMaxMotos(obj.getQtdMaxMotos());
        setDadosEmpresa(obj.getDadosEmpresa());
        setEndereco(obj.getEndereco());
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

    public Integer getQtdMaxMotos() {
        return qtdMaxMotos;
    }

    public void setQtdMaxMotos(Integer qtdMaxMotos) {
        this.qtdMaxMotos = qtdMaxMotos;
    }

    public Integer getQtdMaxCarros() {
        return qtdMaxCarros;
    }

    public void setQtdMaxCarros(Integer qtdMaxCarros) {
        this.qtdMaxCarros = qtdMaxCarros;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        EstacionamentoDTO other = (EstacionamentoDTO) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

}

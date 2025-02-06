package com.estacionamento.app.dto;

import java.io.Serial;
import java.io.Serializable;

import com.estacionamento.app.entities.Estacionamento;
import com.estacionamento.app.entities.auxiliares.DadosPessoais;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class EstacionamentoInput implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private DadosPessoais dadosEmpresa;
    private Integer qtdMaxMotos;
    private Integer qtdMaxCarros;


    public EstacionamentoInput(Estacionamento obj) {
        if (obj.getId()!=null){
            setId(obj.getId());
        }
        setQtdMaxCarros(obj.getQtdMaxCarros());
        setQtdMaxMotos(obj.getQtdMaxMotos());
        setDadosEmpresa(obj.getDadosEmpresa());
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

    

}

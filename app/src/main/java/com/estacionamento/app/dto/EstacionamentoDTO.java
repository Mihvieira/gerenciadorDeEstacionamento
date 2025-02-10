package com.estacionamento.app.dto;

import java.io.Serial;
import java.io.Serializable;

import com.estacionamento.app.entities.Estacionamento;
import com.estacionamento.app.entities.auxiliares.DadosPessoais;
import com.estacionamento.app.entities.auxiliares.Endereco;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class EstacionamentoDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private DadosPessoais dadosEmpresa;
    private Endereco endereco;
    private Integer qtdMaxMotos;
    private Integer qtdMaxCarros;
    private Double precoPorHora;


    public EstacionamentoDTO(Long id, DadosPessoais dadosEmpresa, Endereco endereco, Integer qtdMaxMotos,
            Integer qtdMaxCarros, Double precoPorHora) {
        if (id !=null) {
            this.id = id;
        }
        this.dadosEmpresa = dadosEmpresa;
        this.endereco = endereco;
        this.qtdMaxMotos = qtdMaxMotos;
        this.qtdMaxCarros = qtdMaxCarros;
        this.precoPorHora = precoPorHora;
    }

    public EstacionamentoDTO(Estacionamento obj) {
        if (obj.getId() != null) {
            setId(obj.getId());
        }
        setQtdMaxCarros(obj.getQtdMaxCarros());
        setQtdMaxMotos(obj.getQtdMaxMotos());
        setDadosEmpresa(obj.getDadosEmpresa());
        setEndereco(obj.getEndereco());
        setPrecoPorHora(obj.getprecoPorHora());
    }


}

package com.estacionamento.app.dto;

import java.io.Serializable;

import com.estacionamento.app.entities.Veiculo;
import com.estacionamento.app.entities.auxiliares.TipoVeiculo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class VeiculoDTO implements Serializable{
    private static final Long serialVersionUID = 1L;

    private Long id;
    private TipoVeiculo tipo_veiculo;
    private String cor;
    private String placa;
    private String modelo;

    public VeiculoDTO(Veiculo obj){
        setId(obj.getId());
        setCor(obj.getCor());
        setModelo(obj.getModelo());
        setPlaca(obj.getPlaca());
<<<<<<< HEAD
        setTipo_veiculo(obj.getTipo());
=======
        setTipo_veiculo(obj.getTipo_veiculo());
>>>>>>> 71cb4fd (adiciona exceção ResourceNotFoundException; renomeia enums para uso de constantes em maiúsculas; ajusta estado padrão da vaga; atualiza controladores e serviços para usar DTOs;)
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoVeiculo getTipo_veiculo() {
        return tipo_veiculo;
    }

    public void setTipo_veiculo(TipoVeiculo tipo_veiculo) {
        this.tipo_veiculo = tipo_veiculo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    
}

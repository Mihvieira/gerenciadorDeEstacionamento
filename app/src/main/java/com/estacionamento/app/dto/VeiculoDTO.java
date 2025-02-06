package com.estacionamento.app.dto;

import java.io.Serial;
import java.io.Serializable;

import com.estacionamento.app.entities.Veiculo;
import com.estacionamento.app.entities.auxiliares.TipoVeiculo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
public class VeiculoDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private TipoVeiculo tipo;
    private String cor;
    private String placa;
    private String modelo;

    public VeiculoDTO() {
    }


    public VeiculoDTO(Veiculo obj){
        setId(obj.getId());
        setCor(obj.getCor());
        setModelo(obj.getModelo());
        setPlaca(obj.getPlaca());
        setTipo(obj.getTipo());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoVeiculo getTipo() {
        return tipo;
    }

    public void setTipo(TipoVeiculo tipo) {
        this.tipo = tipo;
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

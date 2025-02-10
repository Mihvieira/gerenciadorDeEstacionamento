package com.estacionamento.app.dto;

import java.io.Serial;
import java.io.Serializable;

import com.estacionamento.app.entities.Veiculo;
import com.estacionamento.app.entities.auxiliares.TipoVeiculo;

import lombok.AllArgsConstructor;
import lombok.Data;

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

    
}

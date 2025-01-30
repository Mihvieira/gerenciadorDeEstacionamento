package com.estacionamento.app.entities.auxiliares;

public enum TipoVeiculo {

    moto(0),
    carro(1);

    private final Integer tipo;

    private TipoVeiculo(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getTipo() {
        return tipo;
    }

    public static TipoVeiculo valueTipoveiculo(Integer tipo){
        for (TipoVeiculo value : TipoVeiculo.values()) {
            if (value.getTipo() == tipo) {
                return value;
            }
        }
        throw new IllegalArgumentException("Operação inválida");
    }
}

package com.estacionamento.app.entities.auxiliares;

public enum EstadoVaga {

    Desocupada(0),
    Ocupada(1);

    private Integer estado;

    EstadoVaga(){

    }

    EstadoVaga(Integer estado){
        this.estado = estado;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public static EstadoVaga valueEstadoVaga(Integer estado){
        for (EstadoVaga value : EstadoVaga.values()) {
            if (value.getEstado() == estado) {
                return value;
            }
        }
        throw new IllegalArgumentException("Operação inválida");
    }
}

package com.estacionamento.app.entities.auxiliares;

public enum Operacao {

    saída(0),
    entrada(1);

    private Integer tipoOperacao;

    Operacao(){

    }

    Operacao(Integer tipoOperacao){
        this.tipoOperacao = tipoOperacao;
    }

    public Integer getTipoOperacao() {
        return tipoOperacao;
    }

    public void setTipoOperacao(Integer tipoOperacao) {
        this.tipoOperacao = tipoOperacao;
    }

    public static Operacao valueOperacao(Integer tipoOperacao){
        for (Operacao value : Operacao.values()) {
            if (value.getTipoOperacao() == tipoOperacao) {
                return value;
            }
        }
        throw new IllegalArgumentException("Operação inválida");
    }

}

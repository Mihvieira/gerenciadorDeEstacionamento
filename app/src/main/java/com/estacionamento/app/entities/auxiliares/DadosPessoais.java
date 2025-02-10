package com.estacionamento.app.entities.auxiliares;

import java.io.Serial;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class DadosPessoais implements Serializable{
    @Serial
    private static final long serialVersionUID = 1L;

    private String nome;
    @Column(unique = true)
    private String cnpj;
    private String telefone;

    public DadosPessoais() {
    }


    public DadosPessoais(String nome, String cnpj, String phone) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.telefone = phone;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }


    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    @Override
    public String toString() {
        return "DadosPessoais [nome=" + nome + ", cnpj=" + cnpj + ", " +"phone=" + telefone + "]";
    }

}

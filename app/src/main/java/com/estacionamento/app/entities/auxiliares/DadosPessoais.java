package com.estacionamento.app.entities.auxiliares;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Getter;

@Embeddable
@Getter
public class DadosPessoais implements Serializable{
    private static final Long serialVersionUID = 1L;


    private String nome;
    private String cnpj;
    @Embedded
    private Endereco endereco;
    private String phone;

    public DadosPessoais() {
    }


    public DadosPessoais(String nome, String cnpj, Endereco endereco, String phone) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.phone = phone;
    }


    public String getNome() {
        return nome;
    }



    public void setNome(String nome) {
        this.nome = nome;
    }



    public String getCnpj() {
        return cnpj;
    }



    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }


    public Endereco getEndereco() {
        return endereco;
    }


    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }


    public String getPhone() {
        return phone;
    }



    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Override
    public String toString() {
        return "DadosPessoais [nome=" + nome + ", cnpj=" + cnpj + ", endereco=" + endereco + ", phone=" + phone + "]";
    }

}

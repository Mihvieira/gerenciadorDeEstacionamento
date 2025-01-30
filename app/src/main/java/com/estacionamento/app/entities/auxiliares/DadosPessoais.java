package com.estacionamento.app.entities.auxiliares;

import jakarta.persistence.Embeddable;

@Embeddable
public class DadosPessoais {

    private String nome;
    private String cnpj;
    private String endereco;
    private String phone;

    public DadosPessoais() {
    }


    public DadosPessoais(String nome, String cnpj, String endereco, String phone) {
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



    public String getEndereco() {
        return endereco;
    }



    public void setEndereco(String endereco) {
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

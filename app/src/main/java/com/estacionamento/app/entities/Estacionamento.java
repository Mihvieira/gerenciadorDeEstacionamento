package com.estacionamento.app.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToOne;

public class Estacionamento {

    Long id;
    private Vaga vaga;
    private Veiculo veiculo;
    @OneToOne(mappedBy = "estacionamento_id")
    private Empresa empresa;
    private Integer quantidadeMaxMotos;
    private Integer quantidadeMaxCarros;
    
    public Estacionamento() {
    }

    public Estacionamento(Long id, Vaga vaga, Veiculo veiculo, Integer quantidadeMaxMotos,
            Integer quantidadeMaxCarros) {
        this.id = id;
        this.vaga = vaga;
        this.veiculo = veiculo;
        this.quantidadeMaxMotos = quantidadeMaxMotos;
        this.quantidadeMaxCarros = quantidadeMaxCarros;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Integer getQuantidadeMaxMotos() {
        return quantidadeMaxMotos;
    }

    public void setQuantidadeMaxMotos(Integer quantidadeMaxMotos) {
        this.quantidadeMaxMotos = quantidadeMaxMotos;
    }

    public Integer getQuantidadeMaxCarros() {
        return quantidadeMaxCarros;
    }

    public void setQuantidadeMaxCarros(Integer quantidadeMaxCarros) {
        this.quantidadeMaxCarros = quantidadeMaxCarros;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Estacionamento other = (Estacionamento) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Estacionamento [id=" + id + ", vaga=" + vaga + ", veiculo=" + veiculo + ", quantidadeMaxMotos="
                + quantidadeMaxMotos + ", quantidadeMaxCarros=" + quantidadeMaxCarros + "]";
    }


}

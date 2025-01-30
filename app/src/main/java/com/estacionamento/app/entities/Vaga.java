package com.estacionamento.app.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.estacionamento.app.entities.auxiliares.EstadoVaga;
import com.estacionamento.app.entities.auxiliares.TipoVeiculo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_vaga")
public class Vaga implements Serializable{
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String setor;
    private Integer tipoVaga;
    private Integer estadoVaga;
    @OneToMany(mappedBy = "id.vaga")
    private List<Registro> registros = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "estacionamento_id")
    private Estacionamento estacionamento;
    
    public Vaga() {
    }

    public Vaga(Long id, String setor, TipoVeiculo tipo, EstadoVaga estadoVaga, Estacionamento estacionamento) {
        this.id = id;
        this.setor = setor;
        setTipoVaga(tipo);
        setEstadoVaga(estadoVaga);
        this.estacionamento = estacionamento;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public TipoVeiculo getTipoVaga() {
        return TipoVeiculo.valueTipoveiculo(this.tipoVaga);
    }

    public void setTipoVaga(TipoVeiculo tipo) {
        if (tipo != null) {
            this.tipoVaga = tipo.getTipo();
        }
    }

    public List<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }


    public EstadoVaga getEstadoVaga() {
        return EstadoVaga.valueEstadoVaga(estadoVaga);
    }

    public void setEstadoVaga(EstadoVaga estadoVaga) {
        this.estadoVaga = estadoVaga.getEstado();
    }   

    public Estacionamento getEstacionamento() {
        return estacionamento;
    }

    public void setEstacionamento(Estacionamento estacionamento) {
        this.estacionamento = estacionamento;
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
        Vaga other = (Vaga) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Vaga [id=" + id + ", setor=" + setor + ", tipo=" + tipoVaga + ", estado=" + getEstadoVaga() + "]";
    }


}

package com.estacionamento.app.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.estacionamento.app.entities.auxiliares.EstadoVaga;
import com.estacionamento.app.entities.auxiliares.TipoVeiculo;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Entity
@Table(name = "tb_vaga")
@AllArgsConstructor
@Getter
public class Vaga implements Serializable{
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String setor;
    @Enumerated(EnumType.STRING)
    private TipoVeiculo tipo;
    @Enumerated(EnumType.STRING)
    private EstadoVaga estadoVaga;
    @OneToMany(mappedBy = "vaga")
    private List<Registro> registros = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "estacionamento_id")
    @NotNull
    private Estacionamento estacionamento;

    public Vaga() {
    }

    public Vaga(String setor, TipoVeiculo tipo, Estacionamento estacionamento) {
        this.setor = setor;
        this.tipo = tipo;
        this.estadoVaga = EstadoVaga.DESOCUPADA;
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

    public TipoVeiculo getTipo() {
        return this.tipo;
    }

    public void setTipo(TipoVeiculo tipo) {
            this.tipo = tipo;
    }

    public List<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }


    public EstadoVaga getEstadoVaga() {
        return this.estadoVaga;
    }

    public void setEstadoVaga(EstadoVaga estadoVaga) {
        this.estadoVaga = estadoVaga;
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
        return "Vaga [id=" + id + ", setor=" + setor + ", tipo=" + tipo + ", estado=" + getEstadoVaga() + "]";
    }


}

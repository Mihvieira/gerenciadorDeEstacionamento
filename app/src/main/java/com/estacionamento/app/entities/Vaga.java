package com.estacionamento.app.entities;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_vaga")
@AllArgsConstructor
@Getter
public class Vaga implements Serializable{
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String setor;
    @Enumerated(EnumType.STRING)
    private TipoVeiculo tipoVeiculo;
    @Enumerated(EnumType.STRING)
    private EstadoVaga estadoVaga;
    @OneToMany(mappedBy = "vaga")
    private List<Registro> registros = new ArrayList<>();

    public Vaga() {
    }

    public Vaga(String setor, TipoVeiculo tipo) {
        this.setor = setor;
<<<<<<< HEAD
        this.tipoVeiculo = tipo;
=======
        this.tipoVaga = tipo;
>>>>>>> 71cb4fd (adiciona exceção ResourceNotFoundException; renomeia enums para uso de constantes em maiúsculas; ajusta estado padrão da vaga; atualiza controladores e serviços para usar DTOs;)
        this.estadoVaga = EstadoVaga.DESOCUPADA;
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

    public TipoVeiculo getTipoVeiculo() {
        return this.tipoVeiculo;
    }

    public void setTipoVeiculo(TipoVeiculo tipo) {
            this.tipoVeiculo = tipo;
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
        return "Vaga [id=" + id + ", setor=" + setor + ", tipo=" + tipoVeiculo + ", estado=" + getEstadoVaga() + "]";
    }


}

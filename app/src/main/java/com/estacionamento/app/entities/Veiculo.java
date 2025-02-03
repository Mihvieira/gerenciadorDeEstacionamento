package com.estacionamento.app.entities;

import java.util.ArrayList;
import java.util.List;

import com.estacionamento.app.entities.auxiliares.TipoVeiculo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "tb_veiculo")
@AllArgsConstructor
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer tipo_veiculo;
    @Column(nullable = false, unique = true)
    private String placa;
    private String modelo;
    @OneToMany(mappedBy = "veiculo")
    private List<Registro> registros = new ArrayList<>();

    public Veiculo() {
    }

    public Veiculo(TipoVeiculo tipo_veiculo, String placa, String modelo) {
        setTipo_veiculo(tipo_veiculo);
        this.placa = placa;
        this.modelo = modelo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoVeiculo getTipo_veiculo() {
        return TipoVeiculo.valueTipoveiculo(tipo_veiculo);
    }

    public void setTipo_veiculo(TipoVeiculo tipo_veiculo) {
        this.tipo_veiculo = tipo_veiculo.getTipo();
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public List<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
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
        Veiculo other = (Veiculo) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Veiculo [id=" + id + ", tipo_veiculo=" + tipo_veiculo + ", placa=" + placa + ", modelo=" + modelo
                + ", registros=" + registros + "]";
    }

}

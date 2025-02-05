package com.estacionamento.app.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.estacionamento.app.entities.auxiliares.TipoVeiculo;

import jakarta.persistence.Column;
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
import lombok.Setter;

@Entity
@Table(name = "tb_veiculo")
@AllArgsConstructor
@Getter
@Setter
public class Veiculo implements Serializable{
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    @Enumerated(EnumType.STRING)
    private TipoVeiculo tipo;
    private String cor;
    @Column(nullable = false, unique = true)
    private String placa;
    private String modelo;
    @OneToMany(mappedBy = "veiculo")
    private List<Registro> registros = new ArrayList<>();

    public Veiculo() {
    }

    public Veiculo(TipoVeiculo tipo, String cor, String placa, String modelo) {
        this.tipo = tipo;
        this.cor = cor;
        this.placa = placa;
        this.modelo = modelo;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoVeiculo getTipo() {
        return this.tipo;
    }

    public String getCor() {
        return cor;
    }


    public void setCor(String cor) {
        this.cor = cor;
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

    public void setRegistros(List<Registro> novosRegistros) {
        if (novosRegistros == null) {
            throw new IllegalArgumentException("A lista de registros não pode ser nula");
        }
        // Cópia defensiva para proteger a lista interna
        this.registros = new ArrayList<>(novosRegistros);
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
            return other.id == null;
        } else return id.equals(other.id);
    }

    @Override
    public String toString() {
        return "Veiculo [id=" + id + ", tipo_veiculo=" + tipo + ", placa=" + placa + ", modelo=" + modelo
                + ", registros=" + registros + "]";
    }

}

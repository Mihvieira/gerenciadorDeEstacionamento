package com.estacionamento.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.estacionamento.app.entities.Vaga;
import com.estacionamento.app.entities.auxiliares.EstadoVaga;
import com.estacionamento.app.entities.auxiliares.TipoVeiculo;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Long> {

    @Query("SELECT v FROM Vaga v WHERE v.estadoVaga = :estadoVaga AND v.tipo = :tipo")
    List<Vaga> findVagasPorEstadoTipo(EstadoVaga estadoVaga, TipoVeiculo tipo);

}

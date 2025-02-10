package com.estacionamento.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.estacionamento.app.entities.Vaga;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Long>{

    @Query("select v from vaga v where v.estadoVaga = DESOCUPADA AND v.tipoVaga = MOTO")
    List<Vaga> findEmptyMotoVagas();

    @Query("select v from vaga v where v.estadoVaga = DESOCUPADA AND v.tipoVaga = CARRO")
    List<Vaga> findEmptyCarroVagas();


}

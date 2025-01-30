package com.estacionamento.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estacionamento.app.entities.Vaga;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Long>{

}

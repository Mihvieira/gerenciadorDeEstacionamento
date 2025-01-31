package com.estacionamento.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estacionamento.app.entities.Estacionamento;

public interface EstacionamentoRepository extends JpaRepository<Estacionamento, Long>{

}

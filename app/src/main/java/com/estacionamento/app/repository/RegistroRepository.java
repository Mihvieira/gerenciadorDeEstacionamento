package com.estacionamento.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estacionamento.app.entities.Registro;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Long>{

}

package com.estacionamento.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estacionamento.app.entities.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

}

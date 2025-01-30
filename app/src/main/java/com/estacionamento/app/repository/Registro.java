package com.estacionamento.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estacionamento.app.entities.pk.RegistroPK;

public interface Registro extends JpaRepository<Registro, RegistroPK>{

}

package com.estacionamento.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.estacionamento.app.entities.Registro;

import java.util.Optional;

@Repository
public interface RegistroRepository extends JpaRepository<Registro, Long>{

    @Query("SELECT r FROM Registro r WHERE r.entrada = :date OR r.saida = :date")
    Optional<Registro> findByDate(String date);

}

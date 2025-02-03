package com.estacionamento.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.estacionamento.app.entities.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long>{

    @Query("SELECT v FROM Veiculo v WHERE v.placa = :placa")
    Optional<Veiculo> findByPlaca(String placa);

}

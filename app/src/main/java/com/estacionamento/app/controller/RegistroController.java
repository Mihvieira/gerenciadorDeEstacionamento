package com.estacionamento.app.controller;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.Arguments;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.estacionamento.app.dto.RegistroDTO;
import com.estacionamento.app.service.RegistroService;

@Controller
public class RegistroController {

    @Autowired
    private RegistroService service;

    @QueryMapping
    public List<RegistroDTO> registros() {
        return this.service.findAll();
    }

    @QueryMapping
    public RegistroDTO registroPorId(@Argument Long id) {
        return this.service.findById(id);
    }

    @QueryMapping
    public RegistroDTO registroPorData(@Argument String data) {
        return this.service.findByDate(data);
    }

    @MutationMapping
    public RegistroDTO criarRegistro(@Argument Long vaga_id, @Argument Long veiculo_id,
            @Argument OffsetDateTime entrada, @Argument OffsetDateTime saida) {
        var registro = new RegistroDTO(null, vaga_id, veiculo_id, entrada, saida);
        return this.service.insert(registro);
    }

    @MutationMapping
    public RegistroDTO incluirSaidaRegistro(@Argument Long id, @Argument OffsetDateTime saida) {
        return this.service.update(id, saida);
    }

    @MutationMapping
    public RegistroDTO atualizarRegistro(@Argument Long id, @Argument Long vaga_id, @Argument Long veiculo_id,
            @Argument OffsetDateTime entrada, @Argument OffsetDateTime saida) {
        var registro = new RegistroDTO(id, vaga_id, veiculo_id, entrada, saida);
        return this.service.insert(registro);
    }

    @MutationMapping
    public Boolean excluirRegistro(@Argument Long id) {
        this.service.delete(id);
        return true;
    }

}

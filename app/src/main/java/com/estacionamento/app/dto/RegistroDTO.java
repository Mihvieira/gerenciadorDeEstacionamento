package com.estacionamento.app.dto;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

import com.estacionamento.app.entities.Registro;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegistroDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long vaga_id;
    private Long veiculo_id;
    private Instant entrada;
    private Instant saida;


    public RegistroDTO(Registro obj) {
        setId(obj.getId());
        setEntrada(obj.getEntrada());
        setVaga_id(obj.getVaga().getId());
        setVeiculo_id(obj.getVeiculo().getId());
    }


}

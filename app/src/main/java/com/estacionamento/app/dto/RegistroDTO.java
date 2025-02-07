package com.estacionamento.app.dto;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.time.OffsetDateTime;

import com.estacionamento.app.entities.Registro;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegistroDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long vaga_id;
    private Long veiculo_id;
    private OffsetDateTime entrada;
    private OffsetDateTime saida;


    public RegistroDTO(Registro obj) {
        setId(obj.getId());
        setEntrada(obj.getEntrada());
        setVaga_id(obj.getVaga().getId());
        setVeiculo_id(obj.getVeiculo().getId());
        setSaida(obj.getSaida());
    }    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RegistroDTO other = (RegistroDTO) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }


    


}

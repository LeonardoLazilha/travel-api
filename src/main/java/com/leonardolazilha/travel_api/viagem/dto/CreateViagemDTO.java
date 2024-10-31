package com.leonardolazilha.travel_api.viagem.dto;

import com.leonardolazilha.travel_api.viagem.Status;
import com.leonardolazilha.travel_api.viagem.Viagem;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

public record CreateViagemDTO(
        @NotBlank(message = "O destino não pode estar em branco")
        @Size(max = 255, message = "O destino deve ter no máximo 255 caracteres")
        String destino,

        @NotNull(message = "A data de ida é obrigatória")
        @Future(message = "A data de ida deve estar no futuro")
        LocalDate dataIda,

        @NotNull(message = "A data de volta é obrigatória")
        @Future(message = "A data de volta deve estar no futuro")
        LocalDate dataVolta,

        @Size(max = 1000, message = "A descrição deve ter no máximo 1000 caracteres")
        String descricao,

        @NotNull(message = "O status é obrigatório")
        Status status
) {
        public static CreateViagemDTO fromEntity(Viagem viagemSalva) {
                return new CreateViagemDTO(
                        viagemSalva.getDestino(),
                        viagemSalva.getDataIda(),
                        viagemSalva.getDataVolta(),
                        viagemSalva.getDescricao(),
                        viagemSalva.getStatus()
                );
        }
}
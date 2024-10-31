package com.leonardolazilha.travel_api.viagem.dto;

import com.leonardolazilha.travel_api.viagem.Status;
import com.leonardolazilha.travel_api.viagem.Viagem;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record ResponseViagemDTO(
        Long id,
        String destino,
        LocalDate dataIda,
        LocalDate dataVolta,
        String descricao,
        Status status,
        LocalDateTime dataCriacao,
        LocalDateTime ultimaAtualizacao
) {
    public static ResponseViagemDTO fromEntity(Viagem viagem) {
        return new ResponseViagemDTO(
                viagem.getId(),
                viagem.getDestino(),
                viagem.getDataIda(),
                viagem.getDataVolta(),
                viagem.getDescricao(),
                viagem.getStatus(),
                viagem.getDataCriacao(),
                viagem.getUltimaAtualizacao()
        );
    }
}
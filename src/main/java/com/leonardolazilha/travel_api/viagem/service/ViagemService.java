package com.leonardolazilha.travel_api.viagem.service;

import com.leonardolazilha.travel_api.viagem.Viagem;
import com.leonardolazilha.travel_api.viagem.ViagemRepository;
import com.leonardolazilha.travel_api.viagem.dto.CreateViagemDTO;
import com.leonardolazilha.travel_api.viagem.dto.ResponseViagemDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ViagemService {

    private final ViagemRepository viagemRepository;

    @Transactional
    public ResponseViagemDTO create(CreateViagemDTO data){
        Viagem viagem = new Viagem(data);
        Viagem viagemSalva = viagemRepository.save(viagem);
        return ResponseViagemDTO.fromEntity(viagemSalva);
    }
}

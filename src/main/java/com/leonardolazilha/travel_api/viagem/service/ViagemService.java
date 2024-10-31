package com.leonardolazilha.travel_api.viagem.service;

import com.leonardolazilha.travel_api.viagem.Viagem;
import com.leonardolazilha.travel_api.viagem.ViagemRepository;
import com.leonardolazilha.travel_api.viagem.dto.CreateViagemDTO;
import com.leonardolazilha.travel_api.viagem.dto.ResponseViagemDTO;
import com.leonardolazilha.travel_api.viagem.exceptions.ViagemNotFoundException;
import jakarta.persistence.Id;
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

    @Transactional
    public void deleteById(Long id) {
        if (viagemRepository.existsById(id)) {
            viagemRepository.deleteById(id);
        } else {
            throw new ViagemNotFoundException();
        }
    }
}

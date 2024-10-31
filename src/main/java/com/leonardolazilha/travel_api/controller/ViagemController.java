package com.leonardolazilha.travel_api.controller;

import com.leonardolazilha.travel_api.viagem.dto.CreateViagemDTO;
import com.leonardolazilha.travel_api.viagem.dto.ResponseViagemDTO;
import com.leonardolazilha.travel_api.viagem.service.ViagemService;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/viagens")
@RequiredArgsConstructor
public class ViagemController {

    private final ViagemService viagemService;

    @PostMapping
    public ResponseEntity<ResponseViagemDTO> createViagem(@RequestBody CreateViagemDTO data){
        ResponseViagemDTO viagem = viagemService.create(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(viagem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteViagem (@PathVariable Long id){
        viagemService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

package com.leonardolazilha.travel_api.viagem;

import com.leonardolazilha.travel_api.viagem.dto.CreateViagemDTO;
import com.leonardolazilha.travel_api.viagem.dto.ResponseViagemDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.print.attribute.standard.MediaSize;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "Viagem")
@Table(name = "viagem")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Viagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String destino;

    @Column(name = "data_ida")
    private LocalDate dataIda;

    @Column(name = "data_volta")
    private LocalDate dataVolta;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "ultima_atualizacao")
    private LocalDateTime ultimaAtualizacao;

    public Viagem(ResponseViagemDTO data) {
        this.destino = data.destino();
        this.dataIda = data.dataIda();
        this.dataVolta = data.dataVolta();
        this.descricao = data.descricao();
        this.status = data.status();
        this.dataCriacao = data.dataCriacao();
        this.ultimaAtualizacao = data.ultimaAtualizacao();
    }

    public Viagem(CreateViagemDTO data) {
        this.destino = data.destino();
        this.dataIda = data.dataIda();
        this.dataVolta = data.dataVolta();
        this.descricao = data.descricao();
        this.status = (data.status() != null) ? data.status() : Status.PLANEJADA;
        this.dataCriacao = LocalDateTime.now();
        this.ultimaAtualizacao = LocalDateTime.now();
    }

}

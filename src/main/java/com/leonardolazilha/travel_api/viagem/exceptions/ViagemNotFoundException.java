package com.leonardolazilha.travel_api.viagem.exceptions;

import org.springframework.context.ApplicationContextException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ViagemNotFoundException extends ApplicationContextException {

    public ViagemNotFoundException() {
        super("Viagem não encontrada.");
    }
}
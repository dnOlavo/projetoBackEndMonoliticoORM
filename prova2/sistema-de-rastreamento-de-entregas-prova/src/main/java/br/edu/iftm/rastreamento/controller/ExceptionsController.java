package br.edu.iftm.rastreamento.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.iftm.rastreamento.service.exceptions.NaoAcheiException;

@ControllerAdvice
public class ExceptionsController {

    @ExceptionHandler(NaoAcheiException.class)
    public ResponseEntity<String> handleNaoAcheiException(NaoAcheiException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Ocorreu um erro interno no servidor. Por favor, tente novamente mais tarde.");
    }
}

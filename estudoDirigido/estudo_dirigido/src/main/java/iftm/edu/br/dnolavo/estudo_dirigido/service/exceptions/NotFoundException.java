package iftm.edu.br.dnolavo.estudo_dirigido.service.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
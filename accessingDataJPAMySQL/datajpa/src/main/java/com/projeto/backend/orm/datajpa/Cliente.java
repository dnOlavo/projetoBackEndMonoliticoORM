package com.projeto.backend.orm.datajpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cliente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String primeiroNome;
    private String ultimoNome;

    protected Cliente() {}

    public Cliente(String primeiroNome, String ultimoNome) {
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
    }

    @Override
    public String toString() {
        return String.format(
            "Cliente[id=%d, primeiroNome='%s', ultimoNome='%s']",
            id, primeiroNome, ultimoNome);
    }

    public Long getId() {
        return id;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }
}

package br.edu.iftm.projeto.backend.orm.onetoone.domain;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Mensagem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String assunto;

    private Date dataEnvio;

    @OneToOne
    @JoinColumn(name = "mensagemCorpo_id", referencedColumnName = "id")
    private MensagemCorpo mensagemCorpo;
}

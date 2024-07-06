package br.edu.iftm.projeto.backend.orm.manytoone.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Item {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;
        String nome;

        @ManyToOne
        Categoria categoria;
}

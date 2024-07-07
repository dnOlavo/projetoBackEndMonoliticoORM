package br.edu.iftm.projeto.backend.orm.onetomany.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Categoria {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;
        String nome;

        // Alteração para @OneToMany com mappedBy para indicar o "outro lado" da relação
        @OneToMany(mappedBy = "categoria")
        private List<Item> items = new ArrayList<Item>();

        public Categoria addComment(Item item){
                items.add(item);
                item.setCategoria(this);
                return this;
            }
        
            public Categoria removeComment(Item item){
                items.remove(item);
                item.setCategoria(this);
                return this;
            }
}
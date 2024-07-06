package br.edu.iftm.projeto.backend.orm.onetomany.repository;

import org.springframework.data.repository.CrudRepository;
import br.edu.iftm.projeto.backend.orm.onetomany.domain.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria,Long> {
    
}
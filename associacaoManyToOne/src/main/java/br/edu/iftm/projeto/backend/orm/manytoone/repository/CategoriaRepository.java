package br.edu.iftm.projeto.backend.orm.manytoone.repository;

import org.springframework.data.repository.CrudRepository;
import br.edu.iftm.projeto.backend.orm.manytoone.domain.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria,Long> {
    
}

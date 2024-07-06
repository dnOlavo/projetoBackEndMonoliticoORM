package br.edu.iftm.projeto.backend.orm.manytoone.repository;

import org.springframework.data.repository.CrudRepository;
import br.edu.iftm.projeto.backend.orm.manytoone.domain.Item;

public interface ItemRepository extends CrudRepository<Item,Long> {
    
}

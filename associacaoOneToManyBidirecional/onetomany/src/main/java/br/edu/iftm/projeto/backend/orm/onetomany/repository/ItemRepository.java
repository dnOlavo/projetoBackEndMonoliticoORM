package br.edu.iftm.projeto.backend.orm.onetomany.repository;

import org.springframework.data.repository.CrudRepository;
import br.edu.iftm.projeto.backend.orm.onetomany.domain.Item;

public interface ItemRepository extends CrudRepository<Item,Long> {
    
}

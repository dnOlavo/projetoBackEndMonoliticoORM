package com.projeto.backend.orm.datajpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

    List<Cliente> findByUltimoNome(String ultimoNome);

    Cliente findById(long id);
    
}
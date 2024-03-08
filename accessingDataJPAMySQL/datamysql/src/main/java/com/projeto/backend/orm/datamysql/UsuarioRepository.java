package com.projeto.backend.orm.datamysql;

import org.springframework.data.repository.CrudRepository;

import com.projeto.backend.orm.datamysql.Usuario;


// Isso será AUTO IMPLEMENTADO pelo Spring em um Bean chamado usuarioRepository
// CRUD refere-se a Criar, Ler, Atualizar, Excluir

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

}
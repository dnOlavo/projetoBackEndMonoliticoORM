package br.edu.iftm.projeto.backend.orm.onetoone.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.iftm.projeto.backend.orm.onetoone.domain.MensagemCorpo;

public interface MensagemCorpoRepository extends JpaRepository<MensagemCorpo, Long>{
    
}
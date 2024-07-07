package br.edu.iftm.projeto.backend.orm.onetoone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.projeto.backend.orm.onetoone.domain.MensagemCorpo;
import br.edu.iftm.projeto.backend.orm.onetoone.repository.MensagemCorpoRepository;

@Service
public class MensagemCorpoService {
    
    @Autowired
    private MensagemCorpoRepository mensagemCorpoRepository;

    public List<MensagemCorpo> findAll() {
        return mensagemCorpoRepository.findAll();
    }

    public MensagemCorpo findById(Long id) {
        return mensagemCorpoRepository.findById(id).orElse(null);
    }

    public MensagemCorpo save(MensagemCorpo mensagemCorpo) {
        return mensagemCorpoRepository.save(mensagemCorpo);
    }

    public void deleteById(Long id) {
        mensagemCorpoRepository.deleteById(id);
    }
}
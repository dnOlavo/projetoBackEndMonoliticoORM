package br.edu.iftm.projeto.backend.orm.onetoone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.iftm.projeto.backend.orm.onetoone.domain.MensagemCorpo;
import br.edu.iftm.projeto.backend.orm.onetoone.service.MensagemCorpoService;

@Controller
@RequestMapping("/mensagensCorpo")
public class MensagemCorpoController {
    
    @Autowired
    private MensagemCorpoService mensagemCorpoService;

    @GetMapping
    public List<MensagemCorpo> getAllMensagensCorpo() {
        return mensagemCorpoService.findAll();
    }

    @GetMapping("/{id}")
    public MensagemCorpo getMensagemCorpoById(@PathVariable Long id) {
        return mensagemCorpoService.findById(id);
    }

    @PostMapping
    public MensagemCorpo createMensagemCorpo(@RequestBody MensagemCorpo mensagemCorpo) {
        return mensagemCorpoService.save(mensagemCorpo);
    }

    @PutMapping("/{id}")
    public MensagemCorpo updateMensagemCorpo(@PathVariable Long id, @RequestBody MensagemCorpo mensagemCorpo) {
        MensagemCorpo existingMensagemCorpo = mensagemCorpoService.findById(id);
        if (existingMensagemCorpo != null) {
            existingMensagemCorpo.setDescricao(mensagemCorpo.getDescricao());
            return mensagemCorpoService.save(existingMensagemCorpo);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteMensagemCorpo(@PathVariable Long id) {
        mensagemCorpoService.deleteById(id);
    }
}
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

import br.edu.iftm.projeto.backend.orm.onetoone.domain.Mensagem;
import br.edu.iftm.projeto.backend.orm.onetoone.service.MensagemService;

@Controller
@RequestMapping("/mensagens")
public class MensagemController {
    
    @Autowired
    private MensagemService mensagemService;

    @GetMapping
    public List<Mensagem> getAllMensagens() {
        return mensagemService.findAll();
    }

    @GetMapping("/{id}")
    public Mensagem getMensagemById(@PathVariable Long id) {
        return mensagemService.findById(id);
    }

    @PostMapping
    public Mensagem createMensagem(@RequestBody Mensagem mensagem) {
        return mensagemService.save(mensagem);
    }

    @PutMapping("/{id}")
    public Mensagem updateMensagem(@PathVariable Long id, @RequestBody Mensagem mensagem) {
        Mensagem existingMensagem = mensagemService.findById(id);
        if (existingMensagem != null) {
            existingMensagem.setAssunto(mensagem.getAssunto());
            existingMensagem.setDataEnvio(mensagem.getDataEnvio());
            existingMensagem.setMensagemCorpo(mensagem.getMensagemCorpo());
            return mensagemService.save(existingMensagem);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteMensagem(@PathVariable Long id) {
        mensagemService.deleteById(id);
    }
}

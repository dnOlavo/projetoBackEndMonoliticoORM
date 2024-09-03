package br.edu.iftm.rastreamento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.rastreamento.model.Pacote;
import br.edu.iftm.rastreamento.model.Rastreamento;
import br.edu.iftm.rastreamento.service.exceptions.NaoAcheiException;

@Service
public class RastreamentoService {

    @Autowired
    private PacoteService pacoteService;

    public List<Rastreamento> getRastreamentos(Long id) {
        Pacote pacote = pacoteService.getPacoteById(id);
        if (pacote.getRastreamentos().isEmpty()) {
            throw new NaoAcheiException("Nenhum rastreamento encontrado para o pacote com ID " + id);
        }
        return pacote.getRastreamentos();
    }
}

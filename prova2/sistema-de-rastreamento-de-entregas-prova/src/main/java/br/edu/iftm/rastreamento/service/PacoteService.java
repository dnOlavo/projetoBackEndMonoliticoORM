package br.edu.iftm.rastreamento.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iftm.rastreamento.model.Pacote;
import br.edu.iftm.rastreamento.model.Rastreamento;
import br.edu.iftm.rastreamento.repository.PacoteRepository;
import br.edu.iftm.rastreamento.repository.RastreamentoRepository;
import br.edu.iftm.rastreamento.service.exceptions.NaoAcheiException;

@Service
public class PacoteService {

    @Autowired
    private PacoteRepository pacoteRepository;

    @Autowired
    private RastreamentoRepository rastreamentoRepository;

    public List<Pacote> getAllPacotes() {
        Iterable<Pacote> pacotesIterable = pacoteRepository.findAll();
        List<Pacote> pacotesList = new ArrayList<>();
        pacotesIterable.forEach(pacotesList::add);
        return pacotesList;
    }

    public Pacote getPacoteById(Long id) {
        return pacoteRepository.findById(id)
                .orElseThrow(() -> new NaoAcheiException("Pacote com ID " + id + " não encontrado."));
    }

    public Pacote createPacote(Pacote pacote) {
        return pacoteRepository.save(pacote);
    }

    public Pacote updatePacote(Long id, Pacote pacoteDetails) {
        Pacote pacote = pacoteRepository.findById(id)
                .orElseThrow(() -> new NaoAcheiException("Pacote com ID " + id + " não encontrado."));

        pacote.setDestinatario(pacoteDetails.getDestinatario());
        pacote.setEndereco(pacoteDetails.getEndereco());
        pacote.atualizarStatus(pacoteDetails.getStatus(), Date.from(Instant.now()), "Localização atualizada");

        Rastreamento ultimoRastreamento = pacote.getRastreamentos().get(pacote.getRastreamentos().size() - 1);
        rastreamentoRepository.save(ultimoRastreamento);

        return pacoteRepository.save(pacote);
    }

    public void deletePacote(Long id) {
        Pacote pacote = pacoteRepository.findById(id)
                .orElseThrow(() -> new NaoAcheiException("Pacote com ID " + id + " não encontrado."));
        pacoteRepository.delete(pacote);
    }
}

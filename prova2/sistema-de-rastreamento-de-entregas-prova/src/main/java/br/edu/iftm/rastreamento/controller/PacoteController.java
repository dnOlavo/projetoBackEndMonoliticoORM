package br.edu.iftm.rastreamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.iftm.rastreamento.model.Pacote;
import br.edu.iftm.rastreamento.service.PacoteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/pacotes")
@Api(value = "Pacote Controller", tags = {"Pacotes"})
public class PacoteController {

    @Autowired
    private PacoteService pacoteService;

    @ApiOperation(value = "Obter todos os pacotes", response = List.class)
    @GetMapping
    public List<Pacote> getAllPacotes() {
        return pacoteService.getAllPacotes();
    }

    @ApiOperation(value = "Criar um novo pacote", response = Pacote.class)
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Pacote criado com sucesso")
    })
    @PostMapping
    public ResponseEntity<Pacote> createPacote(@RequestBody Pacote pacote) {
        Pacote novoPacote = pacoteService.createPacote(pacote);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoPacote);
    }

    @ApiOperation(value = "Obter pacote por ID", response = Pacote.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Pacote encontrado"),
        @ApiResponse(code = 404, message = "Pacote não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Pacote> getPacoteById(@PathVariable Long id) {
        Pacote pacote = pacoteService.getPacoteById(id);
        return ResponseEntity.ok(pacote);
    }

    @ApiOperation(value = "Atualizar pacote por ID", response = Pacote.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Pacote atualizado com sucesso"),
        @ApiResponse(code = 404, message = "Pacote não encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Pacote> updatePacote(@PathVariable Long id, @RequestBody Pacote pacoteDetails) {
        Pacote pacoteAtualizado = pacoteService.updatePacote(id, pacoteDetails);
        return ResponseEntity.ok(pacoteAtualizado);
    }

    @ApiOperation(value = "Deletar pacote por ID")
    @ApiResponses(value = {
        @ApiResponse(code = 204, message = "Pacote deletado com sucesso"),
        @ApiResponse(code = 404, message = "Pacote não encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePacote(@PathVariable Long id) {
        pacoteService.deletePacote(id);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Buscar pacotes por status", response = List.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Pacotes encontrados"),
        @ApiResponse(code = 204, message = "Nenhum pacote encontrado com o status fornecido"),
        @ApiResponse(code = 400, message = "Parâmetro de status inválido")
    })
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Pacote>> buscarPorStatus(@PathVariable String status) {
        List<Pacote> pacotes = pacoteService.getPacotesByStatus(status);
        if (pacotes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pacotes);
    }

    @ApiOperation(value = "Buscar pacotes por destinatário", response = List.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Pacotes encontrados"),
        @ApiResponse(code = 204, message = "Nenhum pacote encontrado para o destinatário fornecido"),
        @ApiResponse(code = 400, message = "Parâmetro de destinatário inválido")
    })
    @GetMapping("/destinatario/{destinatario}")
    public ResponseEntity<List<Pacote>> buscarPorDestinatario(@PathVariable String destinatario) {
        List<Pacote> pacotes = pacoteService.getPacotesByDestinatario(destinatario);
        if (pacotes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pacotes);
    }
}

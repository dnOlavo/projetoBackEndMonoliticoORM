package br.edu.iftm.rastreamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.iftm.rastreamento.dto.EnderecoDTO;
import br.edu.iftm.rastreamento.service.EnderecoService;
import io.swagger.annotations.*;

@RestController
@RequestMapping("/enderecos")
@Api(value = "Endereço Controller", tags = {"Endereços"})
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @ApiOperation(value = "Obter todos os endereços")
    @GetMapping
    public List<EnderecoDTO> getAllEnderecos() {
        return enderecoService.getAllEnderecos();
    }

    @ApiOperation(value = "Obter endereço por ID")
    @ApiResponses(value = {
        @ApiResponse(code = 302, message = "Endereço encontrado"),
        @ApiResponse(code = 404, message = "Endereço não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDTO> getById(@PathVariable Long id) {
        EnderecoDTO endereco = enderecoService.getEnderecoById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(endereco);
    }

    @ApiOperation(value = "Criar um novo endereço")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Endereço criado com sucesso")
    })
    @PostMapping
    public ResponseEntity<EnderecoDTO> createEndereco(@RequestBody EnderecoDTO enderecoDTO) {
        EnderecoDTO novoEnderecoDTO = enderecoService.createEndereco(enderecoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoEnderecoDTO);
    }
}

package br.edu.iftm.rastreamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.iftm.rastreamento.model.Rastreamento;
import br.edu.iftm.rastreamento.service.RastreamentoService;
import io.swagger.annotations.*;

import java.util.List;

@RestController
@RequestMapping("/rastreamentos")
@Api(value = "Rastreamento Controller", tags = {"Rastreamentos"})
public class RastreamentoController {

    @Autowired
    private RastreamentoService rastreamentoService;

    @ApiOperation(value = "Obter rastreamentos por ID do pacote")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Rastreamentos encontrados"),
        @ApiResponse(code = 404, message = "Pacote ou rastreamentos não encontrados")
    })
    @GetMapping("/{id}")
    public ResponseEntity<List<Rastreamento>> getRastreamentosPacote(@PathVariable Long id) {
        List<Rastreamento> rastreamentos = rastreamentoService.getRastreamentos(id);
        return ResponseEntity.ok(rastreamentos);
    }
}

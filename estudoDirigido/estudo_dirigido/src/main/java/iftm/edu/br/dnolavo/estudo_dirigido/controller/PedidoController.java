package iftm.edu.br.dnolavo.estudo_dirigido.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import iftm.edu.br.dnolavo.estudo_dirigido.domain.Pedido;
import iftm.edu.br.dnolavo.estudo_dirigido.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    
    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/sem-desconto")
    public List<Pedido> getItensSemDesconto() {
        return pedidoService.getItensSemDesconto();
    }

    @GetMapping("/desconto-maior")
    public List<Pedido> getItensComDesconto() {
        return pedidoService.getItensComDesconto();
    }

    @GetMapping("/ordenado-valor-unit")
    public List<Pedido> getItensOrdenadosPorValor() {
        return pedidoService.getItensOrdenadosPorValor();
    }

    @GetMapping("/mais-vendido")
    public Long getProdutoMaisVendido() {
        return pedidoService.getProdutoMaisVendido();
    }

    @GetMapping("/nf-mais-10-unidades")
    public List<Long> findNfWithMoreThan10Units() {
        return pedidoService.findNfWithMoreThan10Units();
    }

    @GetMapping("/valor-total-maior-500")
    public List<Object[]> findTotalValueOfNfGreaterThan500() {
        return pedidoService.findTotalValueOfNfGreaterThan500();
    }
}

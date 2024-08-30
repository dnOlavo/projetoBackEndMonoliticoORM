package iftm.edu.br.dnolavo.estudo_dirigido.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iftm.edu.br.dnolavo.estudo_dirigido.domain.Pedido;
import iftm.edu.br.dnolavo.estudo_dirigido.repository.PedidoRepository;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> getItensSemDesconto() {
        List<Pedido> pedidos = pedidoRepository.findByDesconto(0);
        if (pedidos.isEmpty()) {
            throw new RuntimeException("Nenhum item encontrado");
        }
        return pedidos;
    }

    public List<Pedido> getItensComDesconto() {
        List<Pedido> pedidos = pedidoRepository.findByDescontoGreaterThan(0);
        if (pedidos.isEmpty()) {
            throw new RuntimeException("Nenhum item encontrado");
        }
        return pedidos;
    }

    public List<Pedido> getItensOrdenadosPorValor() {
        List<Pedido> pedidos = pedidoRepository.findAllByOrderByValorUnitDesc();
        if (pedidos.isEmpty()) {
            throw new RuntimeException("Nenhum item encontrado");
        }
        return pedidos;
    }

    public Long getProdutoMaisVendido() {
        Long codProd = pedidoRepository.findTopByOrderByQuantidadeDesc();
        if (codProd == null) {
            throw new RuntimeException("Nenhum item encontrado");
        }
        return codProd;
    }

    public List<Long> findNfWithMoreThan10Units() {
        List<Long> nfId = pedidoRepository.findNfWithMoreThan10Units();
        if (nfId.isEmpty()) {
            throw new RuntimeException("Nenhuma nota fiscal encontrada com mais de 10 unidades vendidas de pelo menos um item");
        }
        return nfId;
    }

    public List<Object[]> findTotalValueOfNfGreaterThan500() {
        List<Object[]> nfTotal = pedidoRepository.findTotalValueOfNfGreaterThan500();
        if (nfTotal.isEmpty()) {
            throw new RuntimeException("Nenhum nota fiscal encontrada com o valor total maior que 500.0");
        }
        return nfTotal;
    }
    

}


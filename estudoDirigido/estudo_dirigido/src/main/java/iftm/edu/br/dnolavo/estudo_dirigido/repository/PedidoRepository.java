package iftm.edu.br.dnolavo.estudo_dirigido.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import iftm.edu.br.dnolavo.estudo_dirigido.domain.Pedido;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long> {

    // Busca todos os pedidos que não possuem desconto aplicado.
    List<Pedido> findByDesconto(int desconto);

    // Busca todos os pedidos que possuem algum desconto aplicado.
    List<Pedido> findByDescontoGreaterThan(int desconto);

    // Retorna todos os pedidos ordenados pelo valor unitário, do maior para o menor.
    List<Pedido> findAllByOrderByValorUnitDesc();

    // Encontra o produto mais vendido, considerando a quantidade total vendida.
    @Query("SELECT p.codProd FROM Pedido p GROUP BY p.codProd ORDER BY SUM(p.quantidade) DESC LIMIT 1")
    Long findTopByOrderByQuantidadeDesc();

    // Localiza as notas fiscais que têm mais de 10 unidades vendidas para pelo menos um item.
    @Query("SELECT DISTINCT p.idNf FROM Pedido p WHERE p.quantidade > 10 GROUP BY p.idNf")
    List<Long> findNfWithMoreThan10Units();

    // Obtém o valor total das notas fiscais que excedem R$500,00, organizando do maior para o menor.
    @Query("SELECT p.idNf, SUM(p.valorUnit * p.quantidade * (1 - p.desconto / 100)) AS total FROM Pedido p GROUP BY p.idNf HAVING SUM(p.valorUnit * p.quantidade * (1 - p.desconto / 100)) > 500 ORDER BY total DESC")
    List<Object[]> findTotalValueOfNfGreaterThan500();

}

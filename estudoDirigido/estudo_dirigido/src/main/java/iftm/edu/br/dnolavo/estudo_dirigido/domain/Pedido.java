package iftm.edu.br.dnolavo.estudo_dirigido.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedido;
    private Long idNf;
    private Long idItem;
    private Long codProd;
    private Double valorUnit;
    private Long quantidade;
    private Long desconto;
}


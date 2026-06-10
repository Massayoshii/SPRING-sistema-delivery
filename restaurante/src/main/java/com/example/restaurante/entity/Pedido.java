package com.example.restaurante.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pedidos")
@Getter
@Setter
public class Pedido {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_pedido")
    private LocalDateTime dataPedido;

    private String status;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

}

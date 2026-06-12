package com.example.restaurante.entity;


import com.example.restaurante.entity.enums.StatusPedido;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

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

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @Enumerated(EnumType.STRING)
    private StatusPedido status = StatusPedido.PREPARANDO;

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itemPedidos;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
}

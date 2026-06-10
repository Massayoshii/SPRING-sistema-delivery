package com.example.restaurante.repository;

import com.example.restaurante.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido , Long> {
}

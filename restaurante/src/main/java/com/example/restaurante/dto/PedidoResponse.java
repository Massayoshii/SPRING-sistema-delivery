package com.example.restaurante.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PedidoResponse(
        Long id,
        String status,
        BigDecimal valorTotal,
        LocalDateTime dataPedido
) {
}

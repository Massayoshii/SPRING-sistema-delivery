package com.example.restaurante.repository;

import com.example.restaurante.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository <Produto , Long> {
}

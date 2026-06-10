package com.example.restaurante.controller;

import com.example.restaurante.entity.Produto;
import com.example.restaurante.service.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@AllArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping
    public Produto criar(@RequestBody Produto produto){
        return produtoService.criar(produto);
    }

    @GetMapping
    public List<Produto> listar(){
        return produtoService.listar();
    }

    @GetMapping("/{id}")
    public Produto buscarPorId(@PathVariable Long id){
        return produtoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Produto atualizar(@PathVariable Long id , @RequestBody Produto produto){
        return produtoService.atualizar(id , produto);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id){
        produtoService.remover(id);
    }


}

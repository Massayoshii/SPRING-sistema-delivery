package com.example.restaurante.controller;

import com.example.restaurante.dto.ProdutoRequest;
import com.example.restaurante.dto.ProdutoResponse;
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
    public ProdutoResponse criar(@RequestBody ProdutoRequest request){
        return produtoService.criar(request);
    }

    @GetMapping
    public List<ProdutoResponse> listar(){
        return produtoService.listar();
    }

    @GetMapping("/{id}")
    public ProdutoResponse buscarPorId(@PathVariable Long id){
        return produtoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ProdutoResponse atualizar(@PathVariable Long id , @RequestBody ProdutoRequest request){
        return produtoService.atualizar(id , request);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id){
        produtoService.remover(id);
    }


}

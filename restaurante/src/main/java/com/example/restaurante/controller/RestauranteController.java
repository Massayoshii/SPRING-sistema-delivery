package com.example.restaurante.controller;

import com.example.restaurante.entity.Restaurante;
import com.example.restaurante.service.RestauranteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
@AllArgsConstructor
public class RestauranteController {

    private final RestauranteService restauranteService;

    @PostMapping
    public Restaurante criar(@RequestBody Restaurante restaurante){
        return restauranteService.criar(restaurante);
    }

    @GetMapping
    public List<Restaurante> listar(){
        return restauranteService.listar();
    }

    @GetMapping("/{id}")
    public Restaurante buscarPorId(@PathVariable Long id){
        return restauranteService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Restaurante atualizar(@PathVariable Long id ,@RequestBody Restaurante restauranteNovo){
        return restauranteService.atualizar(id ,restauranteNovo);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id){
        restauranteService.remover(id);
    }
}

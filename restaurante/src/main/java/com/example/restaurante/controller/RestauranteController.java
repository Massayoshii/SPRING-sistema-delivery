package com.example.restaurante.controller;

import com.example.restaurante.dto.RestauranteRequest;
import com.example.restaurante.dto.RestauranteResponse;
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
    public RestauranteResponse criar(@RequestBody RestauranteRequest request){
        return restauranteService.criar(request);
    }

    @GetMapping
    public List<RestauranteResponse> listar(){
        return restauranteService.listar();
    }

    @GetMapping("/{id}")
    public RestauranteResponse buscarPorId(@PathVariable Long id){
        return restauranteService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public RestauranteResponse atualizar(@PathVariable Long id ,@RequestBody RestauranteRequest request){
        return restauranteService.atualizar(id ,request);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id){
        restauranteService.remover(id);
    }
}

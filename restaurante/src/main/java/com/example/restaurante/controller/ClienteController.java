package com.example.restaurante.controller;

import com.example.restaurante.dto.ClienteRequest;
import com.example.restaurante.dto.ClienteResponse;
import com.example.restaurante.entity.Cliente;
import com.example.restaurante.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping
    public ClienteResponse criar(@RequestBody ClienteRequest request){
        return clienteService.criar(request);
    }
    @GetMapping
    public List<ClienteResponse> buscar(){
        return clienteService.listar();
    }
    @GetMapping("/{id}")
    public ClienteResponse buscarPorId(@PathVariable Long id){
        return clienteService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ClienteResponse atualizar(@PathVariable Long id , @RequestBody ClienteRequest request){
        return clienteService.atualizar(id , request);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id){
        clienteService.remover(id);
    }
}

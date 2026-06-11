package com.example.restaurante.controller;

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
    public Cliente criar(@RequestBody Cliente cliente ){
        return clienteService.criar(cliente);
    }
    @GetMapping
    public List<Cliente> buscar(){
        return clienteService.listar();
    }
    @GetMapping("/{id}")
    public Cliente buscarPorId(@PathVariable Long id){
        return clienteService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Cliente atualizar(@PathVariable Long id , @RequestBody Cliente cliente){
        return clienteService.atualizar(id , cliente);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id){
        clienteService.remover(id);
    }
}

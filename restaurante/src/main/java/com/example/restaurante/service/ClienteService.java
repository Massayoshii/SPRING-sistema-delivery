package com.example.restaurante.service;

import com.example.restaurante.entity.Cliente;
import com.example.restaurante.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public Cliente criar(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listar(){
        return clienteRepository.findAll();
    }

    public Cliente buscarPorId(Long id){
        return clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente com o id " + id + " nao foi encontrado"));
    }

    public Cliente atualizar(Long id , Cliente clienteNovo){
        Cliente cliente = buscarPorId(id);

        cliente.setNome(clienteNovo.getNome());
        cliente.setEndereco(clienteNovo.getEndereco());
        cliente.setTelefone(clienteNovo.getTelefone());
        cliente.setEmail(clienteNovo.getEmail());

        return clienteRepository.save(cliente);
    }

    public void remover(Long id){
        Cliente cliente = buscarPorId(id);

        clienteRepository.delete(cliente);
    }
}



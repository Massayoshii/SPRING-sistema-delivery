package com.example.restaurante.service;

import com.example.restaurante.dto.ClienteRequest;
import com.example.restaurante.dto.ClienteResponse;
import com.example.restaurante.entity.Cliente;
import com.example.restaurante.exceptions.ClienteNaoEncontradoException;
import com.example.restaurante.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteResponse criar(ClienteRequest request){
        Cliente cliente = new Cliente();

        cliente.setNome(request.nome());
        cliente.setEmail(request.email());
        cliente.setTelefone(request.telefone());
        cliente.setEndereco(request.endereco());

        Cliente salvo = clienteRepository.save(cliente);
        return converterParaEntidade(salvo);
    }

    public List<ClienteResponse> listar(){
        return clienteRepository.findAll()
                .stream()
                .map(this::converterParaEntidade)
                .toList();
    }

    public ClienteResponse buscarPorId(Long id){
        Cliente cliente =  clienteRepository.findById(id).orElseThrow(() -> new ClienteNaoEncontradoException(id));
        return converterParaEntidade(cliente);
    }

    public ClienteResponse atualizar(Long id , ClienteRequest request){
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new ClienteNaoEncontradoException(id));

        cliente.setNome(request.nome());
        cliente.setEmail(request.email());
        cliente.setTelefone(request.telefone());
        cliente.setEndereco(request.endereco());

        Cliente salvo = clienteRepository.save(cliente);
        return converterParaEntidade(salvo);
    }

    public void remover(Long id){
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new ClienteNaoEncontradoException(id));
        clienteRepository.delete(cliente);
    }

    private ClienteResponse converterParaEntidade(Cliente cliente) {
        return new ClienteResponse(
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getTelefone(),
                cliente.getEndereco()
        );
    }
}



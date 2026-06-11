package com.example.restaurante.service;

import com.example.restaurante.dto.RestauranteRequest;
import com.example.restaurante.dto.RestauranteResponse;
import com.example.restaurante.entity.Restaurante;
import com.example.restaurante.exceptions.RestauranteNaoEncontradoException;
import com.example.restaurante.repository.RestauranteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RestauranteService {

    private final RestauranteRepository restauranteRepository;

    public RestauranteResponse criar(RestauranteRequest request ) {
        Restaurante restaurante = new Restaurante();

        restaurante.setNome(request.nome());
        restaurante.setEndereco(request.endereco());
        restaurante.setTelefone(request.telefone());

        Restaurante salvo = restauranteRepository.save(restaurante);

        return converterParaResponse(salvo);
    }

    public List<RestauranteResponse> listar(){
        return restauranteRepository.findAll()
                .stream()
                .map(this::converterParaResponse)
                .toList();
    }

    public RestauranteResponse buscarPorId(Long id){
        Restaurante restaurante = restauranteRepository.findById(id).orElseThrow(() -> new RestauranteNaoEncontradoException(id));
        return converterParaResponse(restaurante);
    }

    public RestauranteResponse atualizar(Long id , RestauranteRequest request){
        Restaurante restaurante = restauranteRepository.findById(id).orElseThrow(() -> new RestauranteNaoEncontradoException(id));

        restaurante.setNome(request.nome());
        restaurante.setEndereco(request.endereco());
        restaurante.setTelefone(request.telefone());

       Restaurante atualizado = restauranteRepository.save(restaurante);

       return converterParaResponse(atualizado);
    }

    public void remover(Long id){
        Restaurante restaurante = restauranteRepository.findById(id).orElseThrow(() -> new RestauranteNaoEncontradoException(id));
        restauranteRepository.delete(restaurante);
    }

    private RestauranteResponse converterParaResponse(Restaurante restaurante){

        return new RestauranteResponse(
                restaurante.getId(),
                restaurante.getNome(),
                restaurante.getEndereco(),
                restaurante.getTelefone()
        );
    }


}

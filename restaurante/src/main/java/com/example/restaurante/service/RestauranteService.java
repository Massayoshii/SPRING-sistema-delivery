package com.example.restaurante.service;

import com.example.restaurante.entity.Restaurante;
import com.example.restaurante.repository.RestauranteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RestauranteService {

    private final RestauranteRepository restauranteRepository;

    public Restaurante criar(Restaurante restaurante ) {
        return restauranteRepository.save(restaurante);
    }

    public List<Restaurante> listar(){
        return restauranteRepository.findAll();
    }

    public Restaurante buscarPorId(Long id){
        return  restauranteRepository.findById(id).orElseThrow(() -> new RuntimeException("Restaurante com id " + id + " não encontrado"));
    }

    public Restaurante atualizar(Long id , Restaurante restauranteNovo){
        Restaurante restaurante = buscarPorId(id);

        restaurante.setNome(restauranteNovo.getNome());
        restaurante.setEndereco(restauranteNovo.getEndereco());
        restaurante.setTelefone(restauranteNovo.getTelefone());

        return restauranteRepository.save(restaurante);
    }

    public void remover(Long id){
        Restaurante restaurante = buscarPorId(id);
        restauranteRepository.delete(restaurante);
    }


}

package com.bitequest.BiteQuest.service;

import com.bitequest.BiteQuest.entity.Restaurante;
import com.bitequest.BiteQuest.entity.exception.EntidadeNaoEncontradaExceptionn;
import com.bitequest.BiteQuest.repository.RestauranteRepository;
import com.bitequest.BiteQuest.restaurante.RestauranteCreateRequestDto;
import com.bitequest.BiteQuest.restaurante.RestauranteSimpleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    public Restaurante adicionar(RestauranteCreateRequestDto r){
        Restaurante novoRestaurante = restauranteRepository.save(new Restaurante(
                r.getNome(),
                r.getCnpj(),
                r.getCep(),
                r.getEndereco(),
                r.getNumero(),
                r.getComplemento(),
                r.getDescricao(),
                r.getTipo()
        ));
        return novoRestaurante;
    }


    public List<Restaurante> todosRestaurantes(){
        return restauranteRepository.findAll();
    }

    public Restaurante restaurantePorId(Integer id){
        return restauranteRepository.findById(id).orElseThrow(
                () -> new EntidadeNaoEncontradaExceptionn("Restaurante não encontrado")
        );
    }

    public Restaurante editar(Integer id, RestauranteSimpleResponse r){
        Restaurante restaurante = restauranteExiste(id);
        Restaurante restauranteEditado = restauranteRepository.save(new Restaurante(
                id, // Adiciona o id como primeiro parâmetro
                r.getNome(),
                r.getCnpj(),
                r.getCep(),
                r.getEndereco(),
                r.getNumero(),
                r.getComplemento(),
                r.getDescricao(), // Adicione este campo se ele existir na classe RestauranteSimpleResponse
                r.getTipo()       // Adicione este campo se ele existir na classe RestauranteSimpleResponse
        ));
        return restauranteEditado;
    }

    public void deletarRestaurante(Integer id){
        restauranteRepository.deleteById(id);
    }

    // Outros métodos conforme necessário...

    public Restaurante restauranteExiste(Integer id){
        Restaurante restaurante = restauranteRepository.findById(id).orElseThrow(
                ()-> new EntidadeNaoEncontradaExceptionn("Restaurante não encontrado")
        );
        return restaurante;
    }
}


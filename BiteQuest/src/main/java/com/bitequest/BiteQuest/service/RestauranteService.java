package com.bitequest.BiteQuest.service;

import com.bitequest.BiteQuest.entity.Restaurante;
import com.bitequest.BiteQuest.entity.exception.CardapioNaoEncontradoException;
import com.bitequest.BiteQuest.entity.exception.RestauranteNaoEncontradoException;
import com.bitequest.BiteQuest.repository.RestauranteRepository;
import com.bitequest.BiteQuest.restaurante.RestauranteCreateRequestDto;
import com.bitequest.BiteQuest.restaurante.RestauranteResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;

@Service
public class RestauranteService {
    @Autowired
    private RestauranteRepository restauranteRepository;

    /*public RestauranteCreateRequestDto save(RestauranteCreateRequestDto restaurante) {
        boolean existeEsseCnpj = false;
        List<Restaurante> restaurantes = findAll();

        for (Restaurante rest : restaurantes) {
            if (Objects.equals(rest.getCnpj(), Restaurante.getCnpj())) {
                existeEsseCnpj = true;
                break;
            }
        }

        if (existeEsseCnpj) {
           new CardapioNaoEncontradoException("Cardápio não encontrado");
        }

        restauranteRepository.save(restaurante);
        return restaurante;
    }
    */

    public List<Restaurante> findAll() {
        return restauranteRepository.findAll();
    }

    public Restaurante findById(Integer id) {
        Restaurante restaurante = restauranteRepository.findById(id).orElseThrow(
                ()->new RestauranteNaoEncontradoException("Restaurante não encontrado")
        );
        return restaurante;
    }

    /*public RestauranteResponseDto update(int id, RestauranteResponseDto restaurante) {
        if (restauranteRepository.existsById(id)) {
            Restaurante restauranteAtualizado = findById(id);
            boolean existsCnpj = false;
            List<Restaurante> all = findAll();

            for (Restaurante ep : all) {
                if (Objects.equals(ep.getCnpj(), restaurante.getCnpj())) {
                    existsCnpj = true;
                    break;
                }
            }

            if (existsCnpj) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Cnpj já existente!");
            }

            restaurante.setId(restauranteAtualizado.getId());
            restauranteRepository.save(restaurante);

            return restaurante;
        }
        throw new RestauranteNaoEncontradoException("Restaurante não encontrado");
    }
    */

}

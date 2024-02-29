package com.bitequest.BiteQuest.service;

import com.bitequest.BiteQuest.entity.Restaurante;
import com.bitequest.BiteQuest.entity.exception.RestauranteNaoEncontradoException;
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
        Restaurante novoRestaurante = new Restaurante(
                r.getNome(),
                r.getCnpj(),
                r.getCep(),
                r.getEndereco(),
                r.getNumero(),
                r.getComplemento(),
                r.getDescricao(),
                r.getTipo(),
                r.getComentario(), // Adicionado
                r.getHorariosDeFuncionamento() // Adicionado
        );
        return restauranteRepository.save(novoRestaurante);
    }

    public List<Restaurante> todosRestaurantes(){
        return restauranteRepository.findAll();
    }

    public Restaurante restaurantePorId(Integer id){
        return restauranteRepository.findById(id).orElseThrow(
                () -> new RestauranteNaoEncontradoException("Restaurante não encontrado")
        );
    }

    public Restaurante editar(Integer id, RestauranteSimpleResponse r){
        Restaurante restaurante = restauranteExiste(id);
        restaurante.setNome(r.getNome());
        restaurante.setCnpj(r.getCnpj());
        restaurante.setCep(r.getCep());
        restaurante.setEndereco(r.getEndereco());
        restaurante.setNumero(r.getNumero());
        restaurante.setComplemento(r.getComplemento());
        restaurante.setDescricao(r.getDescricao());
        restaurante.setTipo(r.getTipo());
        restaurante.setComentario(r.getComentario()); // Adicionado
        restaurante.setHorariosDeFuncionamento(r.getHorariosDeFuncionamento()); // Adicionado
        return restauranteRepository.save(restaurante);
    }

    public void deletarRestaurante(Integer id){
        restauranteRepository.deleteById(id);
    }

    public Restaurante restauranteExiste(Integer id){
        Restaurante restaurante = restauranteRepository.findById(id).orElseThrow(
                ()-> new RestauranteNaoEncontradoException("Restaurante não encontrado")
        );
        return restaurante;
    }
}


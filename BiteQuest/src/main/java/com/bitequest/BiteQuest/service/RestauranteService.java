package com.bitequest.BiteQuest.service;

import com.bitequest.BiteQuest.cardapio.CardapioCreateRequestDto;
import com.bitequest.BiteQuest.cardapio.mapper.CardapioMapper;
import com.bitequest.BiteQuest.entity.Cardapio;
import com.bitequest.BiteQuest.entity.Restaurante;
import com.bitequest.BiteQuest.entity.Usuario;
import com.bitequest.BiteQuest.entity.exception.CardapioNaoEncontradoException;
import com.bitequest.BiteQuest.entity.exception.RestauranteNaoEncontradoException;
import com.bitequest.BiteQuest.repository.CardapioRepository;
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

    @Autowired
    private CardapioRepository cardapioRepository;

    public Restaurante adicionar(RestauranteCreateRequestDto r, Usuario usuario){
        Restaurante novoRestaurante = new Restaurante(
                r.getNome(),
                r.getCnpj(),
                r.getCep(),
                r.getEndereco(),
                r.getNumero(),
                r.getComplemento(),
                r.getDescricao(),
                r.getTipo(),
                r.getHorariosDeFuncionamento(),
                usuario
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
        restaurante.setHorariosDeFuncionamento(r.getHorariosDeFuncionamento());
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

    public Cardapio adicionarCardapio(Integer idRestaurante, CardapioCreateRequestDto cardapioDto) {
        Restaurante restaurante = restauranteExiste(idRestaurante);
        Cardapio cardapio = CardapioMapper.toEntity(cardapioDto);
        restaurante.addCardapio(cardapio);
        restauranteRepository.save(restaurante);
        return cardapio;
    }

    public Cardapio atualizarCardapio(Integer idRestaurante, Long idCardapio, CardapioCreateRequestDto cardapioDto) {
        Restaurante restaurante = restauranteExiste(idRestaurante);
        Cardapio cardapio = cardapioRepository.findById(idCardapio).orElseThrow(
                () -> new CardapioNaoEncontradoException(idCardapio)
        );
        cardapio.setImagem(cardapioDto.getImagem());
        cardapioRepository.save(cardapio);
        return cardapio;
    }

    public void removerCardapio(Integer idRestaurante, Long idCardapio) {
        Restaurante restaurante = restauranteExiste(idRestaurante);
        Cardapio cardapio = cardapioRepository.findById(idCardapio).orElseThrow(
                () -> new CardapioNaoEncontradoException(idCardapio)
        );
        restaurante.removeCardapio(cardapio);
        cardapioRepository.delete(cardapio);
    }
}


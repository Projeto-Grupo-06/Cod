package com.example.bitequestusuario.service;

import com.example.bitequestusuario.dto.CardapioDTO;
import com.example.bitequestusuario.exception.CardapioNaoEncontradoException;
import com.example.bitequestusuario.model.Cardapio;
import com.example.bitequestusuario.repository.CardapioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardapioService {

    @Autowired
    private CardapioRepository cardapioRepository;

    public Cardapio adicionar(CardapioDTO c){
        Cardapio novoCardapio = cardapioRepository.save(new Cardapio(null,c.getNome(),c.getPreco(),c.getVersao()));
        return novoCardapio;
    }

    public List<Cardapio> todosCardapios(){
        return cardapioRepository.findAll();
    }

    public Cardapio cardapioPorId(Long id){
        Optional<Cardapio> cardapio = cardapioRepository.findById(id);
        return cardapioRepository.findById(id).get();
    }

    public Cardapio editar(CardapioDTO c, Long id){
        Cardapio cardapio = cardapioExiste(id);
        Cardapio cardapioEditado = cardapioRepository.save(new Cardapio(cardapio.getId(),c.getNome(),c.getPreco(),c.getVersao()));
        return cardapioEditado;
    }

    public void deletarCardapio(Long id){
        Optional<Cardapio> cardapio = cardapioRepository.findById(id);
        cardapioRepository.excluirCardapioId(id);
    }
    public void atualizarVersao(Long id, String versao){
        Optional<Cardapio> cardapio = cardapioRepository.findById(id);
        if(cardapio.isPresent()){
            cardapioRepository.atualizarCardapio(id,versao);
        }
    }

    public Cardapio cardapioExiste(Long id){
        Cardapio cardapio = cardapioRepository.findById(id).orElseThrow(
                ()-> new CardapioNaoEncontradoException()
        );
        return cardapio;
    }
}


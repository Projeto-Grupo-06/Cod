package com.bitequest.BiteQuest.service;

import com.bitequest.BiteQuest.cardapio.CardapioCreateRequestDto;
import com.bitequest.BiteQuest.cardapio.CardapioResponseDto;
import com.bitequest.BiteQuest.entity.Cardapio;
import com.bitequest.BiteQuest.entity.exception.CardapioNaoEncontradoException;
import com.bitequest.BiteQuest.repository.CardapioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CardapioService {
    private final CardapioRepository cardapioRepository;

    @Autowired
    public CardapioService(CardapioRepository cardapioRepository) {
        this.cardapioRepository = cardapioRepository;
    }

    public Cardapio adicionar(CardapioCreateRequestDto c) {
        Cardapio novoCardapio = new Cardapio();
        novoCardapio.setImagem(c.getImagem());
        return cardapioRepository.save(novoCardapio);
    }

    public List<Cardapio> todosCardapios() {
        return cardapioRepository.findAll();
    }

    public Cardapio cardapioPorId(Long id) {
        return cardapioRepository.findById(id)
                .orElseThrow(() -> new CardapioNaoEncontradoException(id));
    }

    public void deletarCardapio(Long id) {
        Cardapio cardapio = cardapioRepository.findById(id)
                .orElseThrow(() -> new CardapioNaoEncontradoException(id));
        cardapioRepository.deleteById(id);
    }

    public Cardapio cardapioExiste(Long id) {
        return cardapioRepository.findById(id)
                .orElseThrow(() -> new CardapioNaoEncontradoException(id));
    }
}


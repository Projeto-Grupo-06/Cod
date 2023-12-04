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
        novoCardapio.setNome(c.getNome());
        novoCardapio.setPreco(c.getPreco());
        novoCardapio.setVersao(c.getVersao());
        return cardapioRepository.save(novoCardapio);
    }

    public List<Cardapio> todosCardapios() {
        return cardapioRepository.findAll();
    }

    public Cardapio cardapioPorId(Long id) {
        return cardapioRepository.findById(id)
                .orElseThrow(() -> new CardapioNaoEncontradoException("Cardápio não encontrado"));
    }

    public Cardapio editar(CardapioResponseDto c, Long id) {
        Cardapio cardapio = cardapioRepository.findById(id)
                .orElseThrow(() -> new CardapioNaoEncontradoException("Cardápio não encontrado"));

        cardapio.setNome(c.getNome());
        cardapio.setPreco(c.getPreco());
        cardapio.setVersao(c.getVersao());

        return cardapioRepository.save(cardapio);
    }

    public void deletarCardapio(Long id) {
        Cardapio cardapio = cardapioRepository.findById(id)
                .orElseThrow(() -> new CardapioNaoEncontradoException("Cardápio não encontrado"));
        cardapioRepository.deleteById(id);
    }

    public void cardapioDeletado(Long id) {
        Cardapio cardapio = cardapioRepository.findById(id)
                .orElseThrow(() -> new CardapioNaoEncontradoException("Cardápio não encontrado"));
        if (cardapio.isDeleted()) {
            throw new CardapioNaoEncontradoException("Cardápio já foi deletado");
        }
        cardapioRepository.deleteById(id);
    }

    public void atualizarVersao(Long id, String versao) {
        Cardapio cardapio = cardapioRepository.findById(id)
                .orElseThrow(() -> new CardapioNaoEncontradoException("Cardápio não encontrado"));

        cardapio.setVersao(versao);
        cardapioRepository.save(cardapio);
    }

    public Cardapio cardapioExiste(Long id) {
        return cardapioRepository.findById(id)
                .orElseThrow(() -> new CardapioNaoEncontradoException("Cardápio não encontrado"));
    }
}

package com.bitequest.BiteQuest.controller;

import com.bitequest.BiteQuest.entity.Cardapio;
import com.bitequest.BiteQuest.service.CardapioService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CardapioControllerTest {

    @Mock
    private CardapioService cardapioService;

    @InjectMocks
    private CardapioController cardapioController;

    @Test
    public void testListarCardapios() {
        List<Cardapio> mockCardapios = new ArrayList<>();
        when(cardapioService.todosCardapios()).thenReturn(mockCardapios);

        ResponseEntity<List<Cardapio>> response = cardapioController.listarCardapios();

        assertEquals(ResponseEntity.noContent().build(), response);
        verify(cardapioService, times(1)).todosCardapios();
    }

    @Test
    public void testCardapioPorId() {
        Long id = 1L;
        Cardapio mockCardapio = new Cardapio(); // Mock your Cardapio object here
        when(cardapioService.cardapioPorId(id)).thenReturn(mockCardapio);

        ResponseEntity<Cardapio> response = cardapioController.cardapioPorId(id);

        assertEquals(ResponseEntity.ok(mockCardapio), response);
        verify(cardapioService, times(1)).cardapioPorId(id);
    }

    // Similar tests for other methods like adicionarCardapio, editarCardapio, deletarCardapio, and atualizarVersao
}

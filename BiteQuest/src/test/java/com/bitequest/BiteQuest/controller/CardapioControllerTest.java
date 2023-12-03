package com.bitequest.BiteQuest.controller;
import com.bitequest.BiteQuest.entity.Cardapio;
import com.bitequest.BiteQuest.service.CardapioService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CardapioController.class)
public class CardapioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private CardapioService cardapioService;

    @InjectMocks
    private CardapioController cardapioController;

    @Test
    public void testListarCardapios() throws Exception {
        List<Cardapio> cardapios = new ArrayList<>();
        // Adicionar cardápios à lista

        when(cardapioService.todosCardapios()).thenReturn(cardapios);

        mockMvc.perform(MockMvcRequestBuilders.get("/cardapios")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isEmpty());
    }

    @Test
    public void testCardapioPorId() throws Exception {
        Long id = 1L;
        Cardapio cardapio = new Cardapio();
        // Configurar o cardápio com o ID

        when(cardapioService.cardapioPorId(id)).thenReturn(cardapio);

        mockMvc.perform(MockMvcRequestBuilders.get("/cardapios/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(id));
    }

    // Vou fazer os outros testes para adicionar, editar, deletar e atualizar versão de cardápios

}

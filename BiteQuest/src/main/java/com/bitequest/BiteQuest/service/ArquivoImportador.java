package com.bitequest.BiteQuest.service;

import com.bitequest.BiteQuest.entity.Usuario;
import com.bitequest.BiteQuest.restaurante.RestauranteCreateRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class ArquivoImportador {

    @Autowired
    private RestauranteService restauranteService;

    public void importar(String caminhoArquivo, Usuario usuario) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                RestauranteCreateRequestDto restauranteDto = processarLinha(linha);
                restauranteService.adicionar(restauranteDto, usuario);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private RestauranteCreateRequestDto processarLinha(String linha) {
        String[] campos = linha.split("\t");
        RestauranteCreateRequestDto restauranteDto = new RestauranteCreateRequestDto();
        restauranteDto.setNome(campos[0]);
        restauranteDto.setCnpj(campos[1]);
        restauranteDto.setCep(campos[2]);
        restauranteDto.setEndereco(campos[3]);
        restauranteDto.setNumero(campos[4]);
        restauranteDto.setComplemento(campos[5]);
        restauranteDto.setDescricao(campos[6]);
        restauranteDto.setTipo(campos[7]);
        return restauranteDto;
    }
}


package com.infoprice.teste.helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.infoprice.teste.modules.endereco.enuns.EEstado;
import com.infoprice.teste.modules.endereco.model.Cidade;
import com.infoprice.teste.modules.endereco.model.Endereco;
import com.infoprice.teste.modules.pessoa.model.Pessoa;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class TestsHelper {

    public static String convertObjectToJsonString(Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper.writeValueAsString(object);
    }

    public static Endereco umEndereco() {
        return Endereco.builder()
                .id(100)
                .logradouro("Rua teste")
                .numero("123")
                .complemento("Complemento teste")
                .bairro("Centro")
                .cep("00000-000")
                .cidade(umaCidade())
                .build();
    }

    public static Cidade umaCidade() {
        return Cidade.builder()
                .id(100)
                .nome("São Paulo")
                .estado(EEstado.SP)
                .build();
    }

    public static Pessoa umaPessoa() {
        return Pessoa.builder()
                .id(100)
                .nome("Fulano")
                .cpf("123.432.456-12")
                .email("teste@email.com")
                .dataCadastro(LocalDateTime.of(2020, 4, 22, 16, 50, 0))
                .enderecos(umaListaEnderecos())
                .build();
    }

    public static Pessoa umaPessoaDadosIncompletos() {
        return Pessoa.builder()
                .id(100)
                .cpf("123.432.456-12")
                .email("teste@email.com")
                .dataCadastro(LocalDateTime.of(2020, 4, 22, 16, 50, 0))
                .enderecos(umaListaEnderecos())
                .build();
    }

    private static List<Endereco> umaListaEnderecos() {
        return Arrays.asList(umEndereco());
    }

}

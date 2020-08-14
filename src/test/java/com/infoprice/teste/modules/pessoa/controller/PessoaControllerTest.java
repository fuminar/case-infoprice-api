package com.infoprice.teste.modules.pessoa.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static com.infoprice.teste.helper.TestsHelper.convertObjectToJsonString;
import static com.infoprice.teste.helper.TestsHelper.umaPessoa;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PessoaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void save_deveSalvar_seDadosValidos() throws Exception {
        mockMvc.perform(post("/api/pessoas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(convertObjectToJsonString(umaPessoa()))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome", is("Fulano")))
                .andExpect(jsonPath("$.cpf", is("12343245612")))
                .andExpect(jsonPath("$.email", is("teste@email.com")))
                .andExpect(jsonPath("$.dataCadastro", notNullValue()));
    }

    @Test
    public void findAll_deveListarPessoasPorFiltros_seExistir() throws Exception {
        mockMvc.perform(get("/api/pessoas")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
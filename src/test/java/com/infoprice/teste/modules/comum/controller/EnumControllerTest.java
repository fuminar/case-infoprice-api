package com.infoprice.teste.modules.comum.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EnumControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void deveObterEnumEstado() throws Exception {
        mockMvc.perform(get("/api/enums/estado")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]", is("AC")))
                .andExpect(jsonPath("$[1]", is("AL")))
                .andExpect(jsonPath("$[2]", is("AP")))
                .andExpect(jsonPath("$[3]", is("AM")))
                .andExpect(jsonPath("$[4]", is("BA")))
                .andExpect(jsonPath("$[5]", is("CE")))
                .andExpect(jsonPath("$[6]", is("DF")))
                .andExpect(jsonPath("$[7]", is("ES")))
                .andExpect(jsonPath("$[8]", is("GO")))
                .andExpect(jsonPath("$[9]", is("MA")))
                .andExpect(jsonPath("$[10]", is("MT")))
                .andExpect(jsonPath("$[11]", is("MS")))
                .andExpect(jsonPath("$[12]", is("MG")))
                .andExpect(jsonPath("$[13]", is("PA")))
                .andExpect(jsonPath("$[14]", is("PB")))
                .andExpect(jsonPath("$[15]", is("PR")))
                .andExpect(jsonPath("$[16]", is("PE")))
                .andExpect(jsonPath("$[17]", is("PI")))
                .andExpect(jsonPath("$[18]", is("RJ")))
                .andExpect(jsonPath("$[19]", is("RN")))
                .andExpect(jsonPath("$[20]", is("RS")))
                .andExpect(jsonPath("$[21]", is("RO")))
                .andExpect(jsonPath("$[22]", is("RR")))
                .andExpect(jsonPath("$[23]", is("SC")))
                .andExpect(jsonPath("$[24]", is("SP")))
                .andExpect(jsonPath("$[25]", is("SE")))
                .andExpect(jsonPath("$[26]", is("TO")));
    }

}
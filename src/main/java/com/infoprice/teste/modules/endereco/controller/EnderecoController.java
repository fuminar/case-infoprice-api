package com.infoprice.teste.modules.endereco.controller;

import com.infoprice.teste.modules.comum.dto.PageRequestDto;
import com.infoprice.teste.modules.endereco.model.Endereco;
import com.infoprice.teste.modules.endereco.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService service;

    @GetMapping
    public List<Endereco> getAll(PageRequestDto pageRequest) {
        return service.findAll();
    }

}

package com.infoprice.teste.modules.pessoa.controller;

import com.infoprice.teste.modules.comum.dto.PageRequestDto;
import com.infoprice.teste.modules.pessoa.dto.PessoaRequestDto;
import com.infoprice.teste.modules.pessoa.dto.PessoaResponseDto;
import com.infoprice.teste.modules.pessoa.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @PostMapping
    public PessoaResponseDto save(@Validated @RequestBody PessoaRequestDto objRequest) {
        return PessoaResponseDto.of(service.save(PessoaRequestDto.of(objRequest)));
    }

    @GetMapping
    public Page<PessoaResponseDto> getAll(PageRequestDto pageRequest) {
        return service.findAll(pageRequest);
    }

}

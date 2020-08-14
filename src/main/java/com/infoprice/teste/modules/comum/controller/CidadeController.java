package com.infoprice.teste.modules.comum.controller;

import com.infoprice.teste.modules.comum.enuns.EEstado;
import com.infoprice.teste.modules.comum.model.Cidade;
import com.infoprice.teste.modules.comum.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/cidades")
public class CidadeController {

    @Autowired
    private CidadeRepository cidadeRepository;

    @GetMapping
    public Iterable<Cidade> getAll(EEstado estado) {
        Iterable<Cidade> objResponse = null;
        if (!ObjectUtils.isEmpty(estado)) {
            objResponse = cidadeRepository.findByEstado(estado);
        }
        return objResponse;
    }

}

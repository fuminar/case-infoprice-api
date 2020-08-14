package com.infoprice.teste.modules.comum.controller;

import com.infoprice.teste.modules.comum.enuns.EEstado;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/enums")
public class EnumController {

    @GetMapping("/estado")
    public EEstado[] getEstados() {
        return EEstado.values();
    }

}

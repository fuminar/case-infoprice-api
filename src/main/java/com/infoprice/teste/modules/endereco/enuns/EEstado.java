package com.infoprice.teste.modules.endereco.enuns;

import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

public enum EEstado {

    AC("Acre"),
    AL("Alagoas"),
    AP("Amapá"),
    AM("Amazonas"),
    BA("Bahia"),
    CE("Ceará"),
    DF("Distrito Federal"),
    ES("Espírito Santo"),
    GO("Goiás"),
    MA("Maranhão"),
    MT("Mato Grosso"),
    MS("Mato Grosso do Sul"),
    MG("Minas Gerais"),
    PA("Pará"),
    PB("Paraíba"),
    PR("Paraná"),
    PE("Pernambuco"),
    PI("Piauí"),
    RJ("Rio de Janeiro"),
    RN("Rio Grande do Norte"),
    RS("Rio Grande do Sul"),
    RO("Rondônia"),
    RR("Roraima"),
    SC("Santa Catarina"),
    SP("São Paulo"),
    SE("Sergipe"),
    TO("Tocantins");

    @Getter
    private String descricao;

    EEstado(String descricao) {
        this.descricao = descricao;
    }

    public static String of(List<EEstado> lista) {
        return lista.stream().map(EEstado::getDescricao).collect(Collectors.joining(", "));
    }
}
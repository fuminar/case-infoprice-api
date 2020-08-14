package com.infoprice.teste.modules.comum.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String logradouro;

    private String numero;

    private String complemento;

    private String bairro;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_cidade", referencedColumnName = "id", foreignKey = @ForeignKey(name = "FK_ENDERECO_CID"))
    private Cidade cidade;

    private String cep;

}

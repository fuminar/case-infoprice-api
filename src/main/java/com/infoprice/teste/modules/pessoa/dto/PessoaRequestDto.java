package com.infoprice.teste.modules.pessoa.dto;

import com.infoprice.teste.modules.endereco.model.Endereco;
import com.infoprice.teste.modules.pessoa.model.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.var;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.Arrays;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaRequestDto {

    private Integer id;
    private String nome;
    private LocalDateTime dataCadastro;
    private String cpf;
    private String email;
    private Endereco endereco;

    public static Pessoa of(PessoaRequestDto pessoaRequestDto) {
        var pessoa = new Pessoa();
        BeanUtils.copyProperties(pessoaRequestDto, pessoa);
        pessoa.setEnderecos(Arrays.asList(pessoaRequestDto.getEndereco()));
        return pessoa;
    }

}

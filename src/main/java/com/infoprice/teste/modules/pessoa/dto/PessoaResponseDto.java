package com.infoprice.teste.modules.pessoa.dto;

import com.infoprice.teste.modules.pessoa.model.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.var;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaResponseDto {

    private Integer id;
    private String nome;
    private LocalDateTime dataCadastro;
    private String cpf;
    private String email;

    public static PessoaResponseDto of(Pessoa pessoa) {
        var pessoaResponseDto = new PessoaResponseDto();
        BeanUtils.copyProperties(pessoa, pessoaResponseDto);
        return pessoaResponseDto;
    }

}

package com.infoprice.teste.modules.pessoa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.infoprice.teste.modules.comum.util.StringUtil;
import com.infoprice.teste.modules.endereco.model.Endereco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private LocalDateTime dataCadastro;

    private String cpf;

    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "pessoa", fetch = FetchType.LAZY)
    private List<Endereco> enderecos = new ArrayList<>();

    public void tratarDados() {
        this.cpf = Optional.ofNullable(getCpf()).map(StringUtil::getOnlyNumbers).orElse(null);
        if (this.isNovoCadastro()) {
            this.dataCadastro = LocalDateTime.now();
        }
    }

    @JsonIgnore
    public boolean isNovoCadastro() {
        return id == null;
    }
}

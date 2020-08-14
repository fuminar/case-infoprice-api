package com.infoprice.teste.modules.pessoa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.infoprice.teste.modules.comum.util.StringUtil;
import com.infoprice.teste.modules.comum.model.Endereco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    @JoinTable(name = "ENDERECO_PESSOA", joinColumns = {
            @JoinColumn(name = "FK_PESSOA", referencedColumnName = "ID",
                    foreignKey = @ForeignKey(name = "FK_PESSOA_ENDERECO_PESSOA_REF"))}, inverseJoinColumns = {
            @JoinColumn(name = "FK_ENDERECO", referencedColumnName = "ID",
                    foreignKey = @ForeignKey(name = "FK_PESSOA_ENDERECO_PAR_REF"))})
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Endereco> enderecos;

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

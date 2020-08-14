package com.infoprice.teste.modules.pessoa.service;

import com.infoprice.teste.modules.comum.dto.PageRequestDto;
import com.infoprice.teste.modules.comum.exception.ValidacaoException;
import com.infoprice.teste.modules.comum.repository.EnderecoRepository;
import com.infoprice.teste.modules.pessoa.dto.PessoaResponseDto;
import com.infoprice.teste.modules.pessoa.model.Pessoa;
import com.infoprice.teste.modules.pessoa.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class PessoaService {

    private static final ValidacaoException DADOS_INCOMPLETOS
            = new ValidacaoException("Dados incompletos.");

    @Autowired
    private PessoaRepository repository;
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Transactional
    public Pessoa save(final Pessoa pessoa) {
        validarDados(pessoa);
        pessoa.tratarDados();
        return repository.save(pessoa);
    }

    private void validarDados(Pessoa pessoa) {
        Optional.ofNullable(pessoa.getNome()).orElseThrow(() -> DADOS_INCOMPLETOS);
        Optional.ofNullable(pessoa.getEmail()).orElseThrow(() -> DADOS_INCOMPLETOS);
    }

    public Page<PessoaResponseDto> findAll(PageRequestDto pageRequest) {
        return repository.findAll(pageRequest)
                .map(PessoaResponseDto::of);
    }

}

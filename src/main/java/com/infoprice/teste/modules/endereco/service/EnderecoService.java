package com.infoprice.teste.modules.endereco.service;

import com.infoprice.teste.modules.endereco.model.Endereco;
import com.infoprice.teste.modules.endereco.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;

    public Endereco save(final Endereco endereco) {
        return repository.save(endereco);
    }

    public List<Endereco> findAll() {
        return repository.findAll();
    }

}

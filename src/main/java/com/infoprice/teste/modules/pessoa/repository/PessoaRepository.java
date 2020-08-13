package com.infoprice.teste.modules.pessoa.repository;

import com.infoprice.teste.modules.pessoa.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>,
        QuerydslPredicateExecutor<Pessoa> {

}

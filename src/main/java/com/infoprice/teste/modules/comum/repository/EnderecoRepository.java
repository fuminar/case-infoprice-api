package com.infoprice.teste.modules.comum.repository;

import com.infoprice.teste.modules.comum.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer>,
        QuerydslPredicateExecutor<Endereco> {

}

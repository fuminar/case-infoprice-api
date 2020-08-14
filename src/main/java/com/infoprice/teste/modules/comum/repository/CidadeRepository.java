package com.infoprice.teste.modules.comum.repository;

import com.infoprice.teste.modules.comum.enuns.EEstado;
import com.infoprice.teste.modules.comum.model.Cidade;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CidadeRepository extends PagingAndSortingRepository<Cidade, Integer>,
        QuerydslPredicateExecutor<Cidade> {

    Iterable<Cidade> findByEstado(EEstado estado);

}

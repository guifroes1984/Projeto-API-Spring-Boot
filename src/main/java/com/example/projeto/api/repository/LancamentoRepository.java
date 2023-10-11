package com.example.projeto.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projeto.api.model.Lancamento;
import com.example.projeto.api.repository.lancamento.LancamentoRepositoryQuery;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long>, LancamentoRepositoryQuery {

}

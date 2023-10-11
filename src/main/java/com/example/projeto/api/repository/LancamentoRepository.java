package com.example.projeto.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projeto.api.model.Lancamento;

public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

}

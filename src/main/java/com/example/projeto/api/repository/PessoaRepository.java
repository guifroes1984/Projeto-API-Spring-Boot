package com.example.projeto.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projeto.api.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}

package com.example.projeto.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projeto.api.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}

package com.example.projeto.api.repository.lancamento;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.projeto.api.model.Lancamento;
import com.example.projeto.api.repository.filter.LancamentoFilter;

public interface LancamentoRepositoryQuery {

	Page<Lancamento> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable);
	
}

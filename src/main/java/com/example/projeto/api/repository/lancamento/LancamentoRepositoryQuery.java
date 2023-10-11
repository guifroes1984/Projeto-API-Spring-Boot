package com.example.projeto.api.repository.lancamento;

import java.util.List;

import com.example.projeto.api.model.Lancamento;
import com.example.projeto.api.repository.filter.LancamentoFilter;

public interface LancamentoRepositoryQuery {

	public List<Lancamento> filtrar(LancamentoFilter lancamentoFilter);
	
}

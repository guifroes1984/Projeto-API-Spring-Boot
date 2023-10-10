package com.example.projeto.api.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projeto.api.event.RecursoCriadoEvent;
import com.example.projeto.api.model.Lancamento;
import com.example.projeto.api.repository.LancamentoRepository;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoResource {
	
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
    public List<Lancamento> listar() {
        return lancamentoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Lancamento> criar(@Valid @RequestBody Lancamento lancamento, HttpServletResponse response) {
        Lancamento lancamentoSalva = lancamentoRepository.save(lancamento);

        publisher.publishEvent(new RecursoCriadoEvent(this, response, lancamentoSalva.getCodigo()));

        return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoSalva);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lancamento> buscarPeloId(@PathVariable Long id) {
        Lancamento lancamento = lancamentoRepository.findOne(id);

        return lancamento != null ? ResponseEntity.ok(lancamento) : ResponseEntity.notFound().build();
    }

}

package com.example.projeto.api.resource;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.PathVariable;
=======
>>>>>>> 58dbca354c04d0321aa071a087952ebe8edd9150
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.projeto.api.event.RecursoCriadoEvent;
import com.example.projeto.api.exceptionhandler.ExceptionHandler.Erro;
import com.example.projeto.api.model.Lancamento;
import com.example.projeto.api.repository.LancamentoRepository;
import com.example.projeto.api.service.LancamentoService;
import com.example.projeto.api.service.exception.PessoaInexistenteOuInativaException;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoResource {
<<<<<<< HEAD

=======
	
>>>>>>> 58dbca354c04d0321aa071a087952ebe8edd9150
	@Autowired
	private LancamentoRepository lancamentoRepository;
	
	@Autowired
<<<<<<< HEAD
	private LancamentoService lancamentoService;
=======
    private LancamentoService lancamentoService;
>>>>>>> 58dbca354c04d0321aa071a087952ebe8edd9150
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
<<<<<<< HEAD
	private MessageSource messageSource;
	
	@GetMapping
	public List<Lancamento> listar() {
		return lancamentoRepository.findAll();
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Lancamento> buscarPeloCodigo(@PathVariable Long codigo) {
		Lancamento lancamento = lancamentoRepository.findOne(codigo);
		return lancamento != null ? ResponseEntity.ok(lancamento) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Lancamento> criar(@Valid @RequestBody Lancamento lancamento, HttpServletResponse response) {
		Lancamento lancamentoSalvo = lancamentoService.salvar(lancamento);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, lancamentoSalvo.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoSalvo);
	}
	
	@ExceptionHandler({ PessoaInexistenteOuInativaException.class })
	public ResponseEntity<Object> handlePessoaInexistenteOuInativaException(PessoaInexistenteOuInativaException ex) {
		String mensagemUsuario = messageSource.getMessage("pessoa.inexistente-ou-inativa", null, LocaleContextHolder.getLocale());
		String mensagemDesenvolvedor = ex.toString();
		List<Erro> erros = Arrays.asList(new Erro(mensagemUsuario, mensagemDesenvolvedor));
		return ResponseEntity.badRequest().body(erros);
	}
	
=======
    private MessageSource messageSource;
	
	@GetMapping
    public List<Lancamento> listar() {
        return lancamentoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Lancamento> criar(@Valid @RequestBody Lancamento lancamento, HttpServletResponse response) {
        Lancamento lancamentoSalva = lancamentoService.salvar(lancamento);

        publisher.publishEvent(new RecursoCriadoEvent(this, response, lancamentoSalva.getCodigo()));

        return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoSalva);
    }

    @ExceptionHandler(PessoaInexistenteOuInativaException.class)
    public ResponseEntity<Object> handlePessoaInexistenteOuInativaException(PessoaInexistenteOuInativaException ex) {
        String mensagemUsuario = messageSource.getMessage("pessoa.inexistente-ou-inativa", null, LocaleContextHolder.getLocale());
        String mensagemDesenvolvedor = ex.toString();

        List<Erro> erros = Arrays.asList(new Erro(mensagemUsuario, mensagemDesenvolvedor));

        return ResponseEntity.badRequest().body(erros);
    }

>>>>>>> 58dbca354c04d0321aa071a087952ebe8edd9150
}
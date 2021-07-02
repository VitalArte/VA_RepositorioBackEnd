package br.generation.projetointegrador.redesocial.vitalArte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.generation.projetointegrador.redesocial.vitalArte.model.Tema;
import br.generation.projetointegrador.redesocial.vitalArte.repository.TemaRepository;

@RestController
@RequestMapping("/temas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TemaController {

	@Autowired
	private TemaRepository repository;

	@GetMapping
	public ResponseEntity<List<Tema>> findAllTema() {
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Tema> getById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Tema>> findTema(@PathVariable String nome) {
		return ResponseEntity.ok(repository.findAllByTemaContainingIgnoreCase(nome));
	}

	@GetMapping("/topico/{topico}")
	public ResponseEntity<List<Tema>> findTemaPalavraChave(@PathVariable String topico) {
		return ResponseEntity.ok(repository.findAllByTemaContainsOrPalavraChaveContainsAllIgnoreCase(topico, topico));
	}

	@PostMapping
	public ResponseEntity<Tema> postTema(@RequestBody Tema tema) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tema));
	}

	@PutMapping
	public ResponseEntity<Tema> putTema(@RequestBody Tema tema) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(tema));
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable long id) {
		repository.deleteById(id);
	}
}

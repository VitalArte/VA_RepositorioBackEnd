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

import br.generation.projetointegrador.redesocial.vitalArte.model.Postagem;
import br.generation.projetointegrador.redesocial.vitalArte.repository.PostagemRepository;
import br.generation.projetointegrador.redesocial.vitalArte.service.PostagemService;

@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {

	@Autowired
	private PostagemRepository repository;
	
	@Autowired
	private PostagemService service;

	@GetMapping
	public ResponseEntity<List<Postagem>> findAllPostagem() {
		return ResponseEntity.ok(repository.findAll());

	}

	@GetMapping("/{id}")
	public ResponseEntity<Postagem> getById(@PathVariable long id) {
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());

	}

	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> findByTitulo(@PathVariable String titulo) {
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));

	}
	
	@GetMapping("/usuario/{nome}")
	public ResponseEntity<List<Postagem>> findByUsuarioNome (@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByUsuario_NomeIgnoreCase(nome));
	}

	@PostMapping
	public ResponseEntity<Postagem> postPostagem(@RequestBody Postagem postagem) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));

	}

	@PutMapping
	public ResponseEntity<Postagem> putPostagem(@RequestBody Postagem postagem) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
	}
	
	@PutMapping("/curtir/{id}")
	public ResponseEntity<Postagem> curtirPostagemId(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.curtir(id));
	}
	
	@PutMapping("/descurtir/{id}")
	public ResponseEntity<Postagem> descurtirPostagemId (@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(service.descurtir(id));
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable long id) {
		repository.deleteById(id);

	}

}

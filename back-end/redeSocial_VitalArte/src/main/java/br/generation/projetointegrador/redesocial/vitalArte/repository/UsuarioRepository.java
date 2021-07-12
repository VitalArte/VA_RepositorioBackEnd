package br.generation.projetointegrador.redesocial.vitalArte.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.generation.projetointegrador.redesocial.vitalArte.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	public Optional<Usuario> findByEmail(String email);

	public List<Usuario> findAllByNomeIgnoreCaseContainingOrderByNome(String nome);

	public Usuario findFirstByNome(String nome);

}

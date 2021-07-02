package br.generation.projetointegrador.redesocial.vitalArte.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.generation.projetointegrador.redesocial.vitalArte.model.Tema;

@Repository
public interface TemaRepository extends JpaRepository<Tema, Long> {

	public List<Tema> findAllByTemaContainingIgnoreCase(String tema);

	public List<Tema> findAllByTemaContainsOrPalavraChaveContainsAllIgnoreCase(String tema, String palavra);
}

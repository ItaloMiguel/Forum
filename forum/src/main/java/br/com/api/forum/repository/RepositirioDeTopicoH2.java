package br.com.api.forum.repository;

import br.com.api.forum.model.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RepositirioDeTopicoH2 extends JpaRepository<Topico, Long> {
    Optional<Page<Topico>> findByCursoNome(String nomeCurso, Pageable paginacao);
}

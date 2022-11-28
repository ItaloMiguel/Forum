package br.com.api.forum.repository;

import br.com.api.forum.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface RepositorioDeCursoH2 extends JpaRepository<Curso, Long> {

    Optional<Curso> findByNome(String nome);
}

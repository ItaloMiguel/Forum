package br.com.api.forum.repository;

import br.com.api.forum.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositirioDeTopicoH2 extends JpaRepository<Topico, Long> {
}

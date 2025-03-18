package br.edu.ifpi.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifpi.biblioteca.entity.Livro;
import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findById(long id);
}

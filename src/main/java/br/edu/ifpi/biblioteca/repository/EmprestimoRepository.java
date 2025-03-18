package br.edu.ifpi.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifpi.biblioteca.entity.Emprestimo;
import java.util.List;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
    List<Emprestimo> findById(long id);
}

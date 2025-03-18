package br.edu.ifpi.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ifpi.biblioteca.entity.Usuario;
import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findById(long id);
}

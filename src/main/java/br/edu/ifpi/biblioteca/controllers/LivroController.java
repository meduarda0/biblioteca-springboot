package br.edu.ifpi.biblioteca.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpi.biblioteca.Dto.LivroDto;
import br.edu.ifpi.biblioteca.entity.Livro;
import br.edu.ifpi.biblioteca.repository.LivroRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/livros")

public class LivroController {
    @Autowired
    private LivroRepository livroRepository;

    @GetMapping()
    public List<Livro> listaTodosLivros() {
        return livroRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<String> addLivro(@RequestBody @Valid LivroDto dados) {
        Livro livro = new Livro();
        livroRepository.save(livro);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarLivro(@PathVariable int id, @RequestBody Livro livro) {
        if (livroRepository.existsById((long) id)) {
            livro.setId(id);
            livroRepository.save(livro);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarLivro(@PathVariable int id) {
        if (livroRepository.existsById((long) id)) {
            livroRepository.deleteById((long) id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

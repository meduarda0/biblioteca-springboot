package br.edu.ifpi.biblioteca.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpi.biblioteca.Dto.EmprestimoDto;
import br.edu.ifpi.biblioteca.entity.Emprestimo;
import br.edu.ifpi.biblioteca.repository.EmprestimoRepository;
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
@RequestMapping("/emprestimos")

public class EmprestimoController {
    @Autowired
    private EmprestimoRepository emprestimoRepository;

    @GetMapping()
    public List<Emprestimo> listaTodosEmprestimos() {
        return emprestimoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<String> addEmprestimo(@RequestBody @Valid EmprestimoDto dados) {
        Emprestimo emprestimo = new Emprestimo();
        emprestimoRepository.save(emprestimo);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarEmprestimo(@PathVariable Long id, @RequestBody Emprestimo emprestimo) {
        if (emprestimoRepository.existsById(id)) {
            emprestimo.setId(id);
            emprestimoRepository.save(emprestimo);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarEmprestimo(@PathVariable Long id) {
        if (emprestimoRepository.existsById(id)) {
            emprestimoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

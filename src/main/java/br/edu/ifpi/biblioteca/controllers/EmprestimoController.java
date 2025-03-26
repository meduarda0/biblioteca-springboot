package br.edu.ifpi.biblioteca.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpi.biblioteca.NotificacaoEmail;
import br.edu.ifpi.biblioteca.Dto.EmprestimoDto;
import br.edu.ifpi.biblioteca.entity.*;
import br.edu.ifpi.biblioteca.repository.*;
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
    private UsuarioRepository usuarioRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private EmprestimoRepository emprestimoRepository;
  @Autowired
    private NotificacaoEmail notificacao;
    @GetMapping()
    public List<Emprestimo> listaTodosEmprestimos() {
        return emprestimoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Emprestimo> addEmprestimo(@RequestBody @Valid EmprestimoDto dados) {
        Usuario usuario = usuarioRepository.findById(dados.usuario_id()).orElseThrow();
        Livro livro = livroRepository.findById(dados.livro_id()).orElseThrow();

        Emprestimo emprestimo = new Emprestimo(null, usuario, livro, dados.data_emprestimo(), dados.data_devolucao());
        notificacao.notificarEmprestimo(usuario.getEmail(), livro.getTitulo());
        emprestimoRepository.save(emprestimo);

        return ResponseEntity.ok(emprestimo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Emprestimo> atualizarEmprestimo(@PathVariable Long id, @RequestBody Emprestimo emprestimoAtualizado) {
        return emprestimoRepository.findById(id).map(emprestimo -> {
            if (emprestimoAtualizado.getDataEmprestimo() != null) {
                emprestimo.setDataEmprestimo(emprestimoAtualizado.getDataEmprestimo());
            }
            if (emprestimoAtualizado.getDataDevolucao() != null) {
                emprestimo.setDataDevolucao(emprestimoAtualizado.getDataDevolucao());
            }

            emprestimoRepository.save(emprestimo);
            return ResponseEntity.ok(emprestimo);
        }).orElse(ResponseEntity.notFound().build());
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

package br.edu.ifpi.biblioteca.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate; 

@Entity
@Table(name = "emprestimos") 
public class Emprestimo {

    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY) // O id será gerado automaticamente pelo banco de dados
    private Long id; 
    
    @ManyToOne 
    @JoinColumn (name = "livro_id", nullable = false)
    private Livro livro;

    @ManyToOne
    @JoinColumn (name = "usuario_id", nullable = false)
    private Usuario usuario; // Usuário que fez o empréstimo

    private LocalDate dataEmprestimo; 
    private LocalDate dataDevolucao; 

    public Emprestimo() {}

    public Emprestimo(Long id, Usuario usuario, Livro livro, LocalDate dataEmprestimo, LocalDate dataDevolucao) {
        this.id = id;
        this.usuario = usuario;
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public Long getId() {
        return id; 
    }

    public void setId(Long id) {
        this.id = id; 
    }

    public Usuario getUsuario() {
        return usuario; 
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario; 
    }

    public Livro getLivro() {
        return livro; 
    }

    public void setLivro(Livro livro) {
        this.livro = livro; 
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo; 
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo; 
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao; 
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao; 
    }
}
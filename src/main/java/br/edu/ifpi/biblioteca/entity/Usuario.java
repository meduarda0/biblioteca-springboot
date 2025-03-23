package br.edu.ifpi.biblioteca.entity;

import br.edu.ifpi.biblioteca.Dto.UsuarioDto;
// import jakarta.persistence.Column;
/*Elas importam as anotações do JPA, para criar entidade que será 
mapeada para um banco de dados*/
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 

    private Long id;
    private String nome;

    // @Column (nullable = false, unique = true)//o cpf deve ser unico
    
    private String email;
    private String preferenciaNotificacao;

    public Usuario() {}
    public Usuario(Long id, String nome, String email, String preferenciaNotificacao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.preferenciaNotificacao = preferenciaNotificacao;
    }

    public Usuario (UsuarioDto usuarioDto){
        this.nome=usuarioDto.nome();
        this.email=usuarioDto.email();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // public String getCpf() {
    //     return cpf;
    // }

    // public void setCpf(String cpf) {
    //     this.cpf = cpf;
    // }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPreferenciaNotificacao() {
        return preferenciaNotificacao;
    }

    public void setPreferenciaNotificacao(String preferenciaNotificacao) {
        this.preferenciaNotificacao = preferenciaNotificacao;
    }
}
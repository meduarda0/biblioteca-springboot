package br.edu.ifpi.biblioteca.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioDto (@NotBlank String nome, String cpf, @NotBlank @Email String email ){}

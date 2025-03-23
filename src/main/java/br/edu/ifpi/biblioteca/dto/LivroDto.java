package br.edu.ifpi.biblioteca.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LivroDto (
    @NotBlank String titulo, 
    @NotBlank String autor, 
    @NotBlank String editora, 
    @NotNull Integer ano, 
    @NotNull boolean disponivel) {}

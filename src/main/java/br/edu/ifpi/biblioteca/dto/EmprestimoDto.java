package br.edu.ifpi.biblioteca.Dto;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;

public record EmprestimoDto(
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") LocalDate data_devolucao, 
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") LocalDate data_emprestimo, 
    @NotNull Long livro_id, 
    @NotNull Long usuario_id
) {}

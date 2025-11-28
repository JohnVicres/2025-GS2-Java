package org.biblioteca.app.biblioteca_app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

import lombok.Data;
import lombok.AllArgsConstructor;

@Entity
@Data
@AllArgsConstructor
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional = false)
    private Livro livro;
    @ManyToOne(optional = false)
    private Usuario usuario;
    @NotNull
    private LocalDate dataretirada;
    @NotNull
    private LocalDate datadevolucao;
}

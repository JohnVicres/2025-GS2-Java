package org.biblioteca.app.biblioteca_app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import lombok.Data;
import lombok.AllArgsConstructor;

@Entity
@Data
@AllArgsConstructor
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O livro precisa ter um título")
    private String titulo;
    @NotBlank(message = "O livro precisa ter um autor")
    private String autor;
    @NotBlank(message = "O livro precisa ter um ano de publicação")
    private String anopub;
    private StatusLivro status;

}
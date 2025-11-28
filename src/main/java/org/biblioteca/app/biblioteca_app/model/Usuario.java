package org.biblioteca.app.biblioteca_app.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O username precisa ser inserido")
    private String nome;
    @NotBlank(message = "O E-mail precisa ser inserido")
    @Email(message = "O E-mail inserido não é válido")
    private String email;
}

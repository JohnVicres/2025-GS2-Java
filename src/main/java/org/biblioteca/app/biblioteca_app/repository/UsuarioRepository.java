package org.biblioteca.app.biblioteca_app.repository;

import org.biblioteca.app.biblioteca_app.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}

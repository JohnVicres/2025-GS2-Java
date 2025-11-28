package main.java.org.biblioteca.app.biblioteca_app.repository;

import main.java.org.biblioteca.app.biblioteca_app.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}

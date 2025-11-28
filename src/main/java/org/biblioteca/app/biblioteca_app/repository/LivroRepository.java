package org.biblioteca.app.biblioteca_app.repository;

import org.biblioteca.app.biblioteca_app.model.Livro;
import org.biblioteca.app.biblioteca_app.model.StatusLivro;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByStatus(StatusLivro status);
}

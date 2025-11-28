package org.biblioteca.app.biblioteca_app.repository;

import org.biblioteca.app.biblioteca_app.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

}

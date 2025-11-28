package org.biblioteca.app.biblioteca_app.controller;

import org.biblioteca.app.biblioteca_app.model.Livro;
import org.biblioteca.app.biblioteca_app.model.StatusLivro;
import org.biblioteca.app.biblioteca_app.model.Usuario;
import org.biblioteca.app.biblioteca_app.repository.LivroRepository;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/livros")
public class LivroController {
    private final LivroRepository livroRepository;

    public LivroController(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("livros", livroRepository.findAll());
        return "livros/lista";
    }

    @GetMapping("/disponiveis")
    public String listarDisponivel(Model model) {
        model.addAttribute("livros", livroRepository.findByStatus(StatusLivro.DISPONIVEL));
        return "livros/listadisponiveis";
    }

    @GetMapping("/emprestados")
    public String listarEmprestimo(Model model) {
        model.addAttribute("livros", livroRepository.findByStatus(StatusLivro.EMPRESTADO));
        return "livros/listaemprestados";
    }

    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("livro", new Livro());
        return "livros/form";
    }

    @PostMapping
    public String salvar(@Valid @ModelAttribute("livro") Livro livro,
            BindingResult result) {
        if (result.hasErrors()) {
            return "livros/form";
        }
        livroRepository.save(livro);
        return "redirect:/livros";
    }

    // @DeleteMapping("/remover")
    // public String deletar(@Valid @ModelAttribute("livro") Livro livro,
    // BindingResult result) {
    // if (result.hasErrors()) {
    // return "livros/remove";
    // }
    // livroRepository.delete(livro);
    // return "redirect:/livros";
    // }
}

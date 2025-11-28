package main.java.org.biblioteca.app.biblioteca_app.controller;

import main.java.org.biblioteca.app.biblioteca_app.model.Usuario;
import main.java.org.biblioteca.app.biblioteca_app.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "usuarios/lista";
    }

    @GetMapping("/novo")
    public String novoForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarios/form";
    }

    @PostMapping
    public String salvar(@Valid @ModelAttribute("usuario") Usuario usuario,
            BindingResult result) {
        if (result.hasErrors()) {
            return "usuarios/form";
        }
        usuarioRepository.save(usuario);
        return "redirect:/usuarios";
    }
}
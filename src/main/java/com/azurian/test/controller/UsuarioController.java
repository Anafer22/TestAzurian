package com.azurian.test.controller;

import java.util.LinkedList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.azurian.test.entity.Usuario;
import com.azurian.test.repository.UsuarioRepository;
import com.azurian.test.service.UsuarioService;

import jakarta.validation.Valid;



@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	//Create a new user
	@GetMapping("/add")
	public String add(Usuario usuario) {
		return "add";
	}
	@PostMapping("/create")
	public String create(@Valid Usuario usuario, Errors errors) {
		if(errors.hasErrors()) {
			return "/add";
		}
			usuarioService.save(usuario);
			return "redirect:/";
		}
	@GetMapping("/app")
	public String list(Model model){
		Iterable<Usuario> usuarios = usuarioService.findAll();
		model.addAttribute("usuarios",usuarios);
		return "/app";	
	}
	
	@GetMapping("/fnd")
	public String read(Usuario usuario, Model model) {
		String url = "";
		if (usuario.getCurp() != "" && usuario.getCurp() != null) {
			LinkedList<Usuario> usuarios = new LinkedList<Usuario>();

			Optional<Usuario> oUsuario = usuarioService.findById(usuario.getCurp());
			usuarios.add(((oUsuario.get() != null) ? oUsuario.get() : null));

			model.addAttribute("usuarios", usuarios);
			url = "/qry";
		} else {
			url = "redirect:/";
		}
		return url;
	}
		// Update an user
	@GetMapping("/upd/{curp}")
	public String upd(Usuario usuario, Model model) {
		Optional<Usuario> oUsuario = usuarioService.findById(usuario.getCurp());
		model.addAttribute("usuario", oUsuario);
		return "/upd";
	}

	@PostMapping("/save")
	public String save(Usuario usuario) {
		if (usuario != null) {
			usuarioService.save(usuario);
		}
		return "redirect:/";
	}

	// Delete an User
	@GetMapping("/del/{curp}")
	public String delete(@PathVariable(value = "curp") String usuarioCurp) {
		usuarioService.deleteById(usuarioCurp);
		return "redirect:/";
	}
	
	
}

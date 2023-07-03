package com.azurian.test.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
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
		return "add.html";
	}
	@PostMapping("/create")
	public String create(@Valid Usuario usuario, Errors errors) {
		if(errors.hasErrors()) {
			return "/add.html";
		}
			usuarioService.save(usuario);
			return "redirect:/";
		}
	@GetMapping("/app")
	public String list(Model model){
		Iterable<Usuario> usuarios = usuarioService.findAll();
		model.addAttribute("usuarios",usuarios);
		return "index.html";	
	}
	
	
}

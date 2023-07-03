package com.azurian.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.azurian.test.entity.Usuario;
import com.azurian.test.service.UsuarioService;

@Controller
public class HomeController {
	
	@Autowired
	private UsuarioService usuarioService;
	
		@GetMapping( path = "/")
		public String infoUser(Usuario usuario, Model model){
			Iterable<Usuario> usuarios = usuarioService.findAll();
			model.addAttribute("usuarios", usuarios);
			return "/app";
		}
		
}

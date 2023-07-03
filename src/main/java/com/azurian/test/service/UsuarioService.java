package com.azurian.test.service;

import com.azurian.test.entity.Usuario;


public interface UsuarioService {
	public Usuario save(Usuario usuario);
	public Iterable<Usuario> findAll();

}

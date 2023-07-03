package com.azurian.test.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.azurian.test.entity.Usuario;


public interface UsuarioService {
	public Usuario save(Usuario usuario);
	public Iterable<Usuario> findAll();
	public void deleteById(String curp);
	public Page<Usuario> findAll(Pageable pageable);
	public Optional<Usuario> findById(String curp);

}

package com.azurian.test.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.azurian.test.entity.Usuario;
import com.azurian.test.repository.UsuarioRepository;
import com.azurian.test.service.UsuarioService;


@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	@Transactional
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	@Override
	@Transactional(readOnly=true)
	public Iterable<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

}

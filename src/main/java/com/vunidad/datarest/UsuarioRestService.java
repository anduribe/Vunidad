package com.vunidad.datarest;

import java.util.List;
import java.util.Optional;

import com.vunidad.modelo.Usuario;

public interface UsuarioRestService {
	
	public List<Usuario> findAllUsuarios();	
	public Optional<Usuario> findUsuarioById(Long id);	
	public Usuario saveUsuario(Usuario usuarioNew);	
	public String deleteUsuario(Long id);	
	public String updateUsuario(Usuario usuarioNew);
	
}

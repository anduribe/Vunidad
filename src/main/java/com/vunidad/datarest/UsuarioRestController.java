package com.vunidad.datarest;

import java.util.List;
import java.util.Optional;



import com.vunidad.modelo.Usuario;


public interface UsuarioRestController{
	
	public List<Usuario> getUsuarios();	
	public Optional<Usuario> getUsuarioById(Long id);	
	public Usuario addUsuario(Usuario usuario);	
	public String deleteUsuario(Long id);	
	public String updateUsuario(Usuario usuarioNew);	
	public String test();
	
	
}



package com.vunidad.datarest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vunidad.modelo.Usuario;

@RestController
public class UsuarioControllerImpl implements UsuarioRestController {
	
	@Autowired
	UsuarioRestService usuarioService;

	// http://localhost:8888/usuarios (GET)
	@RequestMapping(value = "/accidentes", method = RequestMethod.GET, produces = "application/json")
	@Override
	public List<Usuario> getUsuarios() {
		return usuarioService.findAllUsuarios();
	}

	// http://localhost:8888/usuarios/1 (GET)
	@Override
	@RequestMapping(value = "/accidentes/{id}", method = RequestMethod.GET, produces = "application/json")
	public Optional<Usuario> getUsuarioById(@PathVariable Long id) {
		return usuarioService.findUsuarioById(id);
	}

	// http://localhost:8888/usuarios/add (ADD)
	@Override
	@RequestMapping(value = "/accidentes/add", method = RequestMethod.POST, produces = "application/json")
	public Usuario addUsuario(Usuario usuario) {
		return usuarioService.saveUsuario(usuario);
	}

	// http://localhost:8888/usuarios/delete/1 (GET)
	@Override
	@RequestMapping(value = "/accidentes/delete/{id}", method = RequestMethod.GET, produces = "application/json")
	public String deleteUsuario(@PathVariable Long id) {
		return usuarioService.deleteUsuario(id);
	}

	// http://localhost:8888/usuarios/update (PATCH)
	@Override
	@RequestMapping(value = "/accidentes/update", method = RequestMethod.PATCH, produces = "application/json")
	public String updateUsuario(Usuario usuarioNew) {
		return usuarioService.updateUsuario(usuarioNew);
	}

	// http://localhost:8888/test (GET)
	@RequestMapping(value = "/test", method = RequestMethod.GET, produces = "application/json")
	@Override
	public String test() {
		return "Test Listoco conexion OK!!";
	}

}

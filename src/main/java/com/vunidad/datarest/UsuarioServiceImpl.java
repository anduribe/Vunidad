package com.vunidad.datarest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vunidad.modelo.Usuario;
import com.vunidad.repo.UsuarioRepo;

@Service

public class UsuarioServiceImpl implements UsuarioRestService {
	
	@Autowired
	UsuarioRepo usuarioRepository;

	@Override
	public List<Usuario> findAllUsuarios() {
		return usuarioRepository.findAll();
	}

	@Override
	public Optional<Usuario> findUsuarioById(Long id) {
		Optional<Usuario> usuario = usuarioRepository.findById(id);
		return usuario;
	}

	@Override
	public Usuario saveUsuario(Usuario usuarioNew) {
		if (usuarioNew != null) {
			return usuarioRepository.save(usuarioNew);
		}
		return new Usuario();
	}

	@Override
	public String deleteUsuario(Long id) {
		if (usuarioRepository.findById(id).isPresent()) {
			usuarioRepository.deleteById(id);
			return "Usuario eliminado correctamente.";
		}
		return "Error! El usuario no existe";
	}

	@Override
	public String updateUsuario(Usuario usuarioUpdated) {
		Long num = usuarioUpdated.getId();
		if (usuarioRepository.findById(num).isPresent()) {
			Usuario usuarioToUpdate = new Usuario();
			usuarioToUpdate.setId(usuarioUpdated.getId());
			usuarioToUpdate.setNombre(usuarioUpdated.getNombre());
			usuarioToUpdate.setFecha(usuarioUpdated.getFecha());
			usuarioToUpdate.setRut(usuarioUpdated.getRut());
			usuarioToUpdate.setAccidente(usuarioUpdated.getAccidente());
			usuarioToUpdate.setAespecial(usuarioUpdated.getAespecial());

			usuarioRepository.save(usuarioToUpdate);
			return "Usuario modificado";
		}
		return "Error al modificar el Usuario";
	}

}

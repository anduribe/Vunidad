package com.vunidad.controller;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vunidad.VunidadApplication;
import com.vunidad.modelo.Usuario;
import com.vunidad.repo.UsuarioRepo;




@Controller
@RequestMapping
public class BasicController 
{
	
	private Logger registroLog = Logger.getLogger(VunidadApplication.class);
	
private final UsuarioRepo urepo;
//creamos un costructor 
public BasicController(UsuarioRepo urepo) 
	{
	this.urepo = urepo;
	}


@RequestMapping("/")
public ModelAndView login() {
	return new ModelAndView("login");
}

@RequestMapping("/logs")
public ModelAndView logs() {
	return new ModelAndView("logs/elLogols");
}



@RequestMapping("/userDashboard")
public ModelAndView userDashboard() {
	registroLog.info(" se logeo el usuario");
	return new ModelAndView("clientes/indexUser");
}

@RequestMapping("/adminDashboard")
public ModelAndView adminDashboard() {
	registroLog.info(" se logeo el administrador");
	return new ModelAndView("indexAdmin");
}
	
	
	@GetMapping("/insert")
	public String view1(Usuario usuario)
	{
		registroLog.info(" se agrego un registro de accidente");
		return "clientes/agregarAccidente";
	}
	
	@PostMapping("/add")
	public String view2(Usuario user, Model m)
	{
		urepo.save(user);
		m.addAttribute("msg", "agregado nuevo accidente");
		return "clientes/agregarAccidente";
	}
	
	@GetMapping("/display")
	public String view3(Model m)
	{
		List list = urepo.findAll();
		if(!list.isEmpty())
		{
			m.addAttribute("data", list);
		}
		else {
			m.addAttribute("msg","no hay registros");
		}
		return "clientes/displayPage";
	}
	// ir a la pagina de actualizacion
	@GetMapping("/edit/{id}")
	
	public String view4(@PathVariable("id") Optional<Long> id, Model m)
	{
		if(id.isPresent())
		{
			Usuario usuario = urepo.getOne(id.get());
			m.addAttribute("edata",usuario);
		}
		else {
			m.addAttribute("edata", new Usuario());
		}
		return "clientes/updatePage";
	}
	//Actualizar registro
	
	@PostMapping("/update/{id}")
	public String view5(Usuario user, Model m)
	{
		urepo.save(user);
		m.addAttribute("data", urepo.findAll());
		m.addAttribute("msg", " registro actualizado");
		registroLog.info(" se actualizo un accidente");
		return "clientes/displayPage";
	}
	
	// borrar registro
	
	@GetMapping("/delete/{id}")
	public String view6(@PathVariable("id") Long id, Model m)
	{
		urepo.deleteById(id);
		m.addAttribute("data", urepo.findAll());
		m.addAttribute("msg", "Registro Borrado");
		registroLog.info(" se elimino un registro de accidente");
		return "clientes/displayPage";
	}

	
	}

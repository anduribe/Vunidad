package com.vunidad.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.vunidad.modelo.Iclientes;
import com.vunidad.repo.IclientesRepo;


@Controller
@RequestMapping
public class IclientesController 
{
	
private final IclientesRepo icrepo;
//creamos un costructor 
public IclientesController(IclientesRepo icrepo) 
	{
	this.icrepo = icrepo;	
	}

	
	@GetMapping("/insertic")
	public String icliente1(Iclientes iclientes)
	{
		return "thymeleaf/iclientes/agregarIclientes";
	}
	
	@PostMapping("/addic")
	public String icliente2(Iclientes iclient, Model m)
	{
		icrepo.save(iclient);
		m.addAttribute("msg", "Cliente Agregado");
		return "thymeleaf/iclientes/agregarIclientes";
	}
	
	@GetMapping("/displayiclientes")
	public String icliente3(Model m)
	{
		List list = icrepo.findAll();
		if(!list.isEmpty())
		{
			m.addAttribute("data", list);
		}
		else {
			m.addAttribute("msg","no hay registros");
		}
		System.out.println("estoy en Info.clientes");
		return "thymeleaf/iclientes/displayIclientes";
		
	}
	// ir a la pagina de actualizacion
	@GetMapping("/editic/{id}")
	public String icliente4(@PathVariable("id") Optional<Long> id, Model m)
	{
		if(id.isPresent())
		{
			Iclientes iclientes = icrepo.getOne(id.get());
			m.addAttribute("edata",iclientes);
		}
		else {
			m.addAttribute("edata", new Iclientes());
		}
		return "thymeleaf/iclientes/updateIclientes";
	}
	//Actualizar registro
	
	@PostMapping("/updateic/{id}")
	public String icliente5(Iclientes iclient, Model m)
	{
		icrepo.save(iclient);
		m.addAttribute("data", icrepo.findAll());
		m.addAttribute("msg", " registro actualizado");
		return "thymeleaf/iclientes/displayIclientes";
	}
	
	// borrar registro
	
	@GetMapping("/deletic/{id}")
	public String icliente6(@PathVariable("id") Long id, Model m)
	{
		icrepo.deleteById(id);
		m.addAttribute("data", icrepo.findAll());
		m.addAttribute("msg", "Registro Borrado");
		return "thymeleaf/iclientes/displayIclientes";
	}

	
	}

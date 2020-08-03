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

import com.vunidad.modelo.Asesorias;
import com.vunidad.repo.AsesoriasRepo;


@Controller
@RequestMapping
public class AsesoriasController 
{
	
private final AsesoriasRepo asrepo;
//creamos un costructor 
public AsesoriasController(AsesoriasRepo asrepo) 
	{
	this.asrepo = asrepo;
	}




	
	@GetMapping("/insertas")
	public String asesoria1(Asesorias asesorias)
	{
		return "thymeleaf/asesorias/agregarAsesorias";
	}
	
	@PostMapping("/addas")
	public String asesoria2(Asesorias asesor, Model m)
	{
		asrepo.save(asesor);
		m.addAttribute("msg", "Agregada Asesoria");
		return "thymeleaf/asesorias/agregarAsesorias";
	}
	
	@GetMapping("/displayasesorias")
	public String asesoria3(Model m)
	{
		List list = asrepo.findAll();
		if(!list.isEmpty())
		{
			m.addAttribute("data", list);
		}
		else {
			m.addAttribute("msg","no hay registros");
		}
		System.out.println("estoy en Asesorias");
		return "thymeleaf/asesorias/displayAsesorias";
		
	}
	// ir a la pagina de actualizacion
	@GetMapping("/editas/{id}")
	public String asesoria4(@PathVariable("id") Optional<Long> id, Model m)
	{
		if(id.isPresent())
		{
			Asesorias asesorias = asrepo.getOne(id.get());
			m.addAttribute("edata",asesorias);
		}
		else {
			m.addAttribute("edata", new Asesorias());
		}
		return "thymeleaf/asesorias/updateAsesorias";
	}
	//Actualizar registro
	
	@PostMapping("/updateas/{id}")
	public String mejora5(Asesorias asesor, Model m)
	{
		asrepo.save(asesor);
		m.addAttribute("data", asrepo.findAll());
		m.addAttribute("msg", " registro actualizado");
		return "thymeleaf/asesorias/displayAsesorias";
	}
	
	// borrar registro
	
	@GetMapping("/deletas/{id}")
	public String asesoria6(@PathVariable("id") Long id, Model m)
	{
		asrepo.deleteById(id);
		m.addAttribute("data", asrepo.findAll());
		m.addAttribute("msg", "Registro Borrado");
		return "thymeleaf/asesorias/displayAsesorias";
	}

	
	}

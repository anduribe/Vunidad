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

import com.vunidad.modelo.Profesionales;
import com.vunidad.repo.ProfesionalesRepo;


@Controller
@RequestMapping
public class ProfesionalesController 
{
	
private final ProfesionalesRepo prorepo;
//creamos un costructor 
public ProfesionalesController(ProfesionalesRepo prorepo) 
	{
	this.prorepo = prorepo;	
	}

	
	@GetMapping("/insertpr")
	public String profesional1(Profesionales profesionales)
	{
		return "profesionales/agregarProfesionales";
	}
	
	@PostMapping("/addpr")
	public String profesional2(Profesionales profe, Model m)
	{
		prorepo.save(profe);
		m.addAttribute("msg", "Profesional Agregado");
		return "profesionales/agregarProfesionales";
	}
	
	@GetMapping("/displayprofesionales")
	public String profesional3(Model m)
	{
		List list = prorepo.findAll();
		if(!list.isEmpty())
		{
			m.addAttribute("data", list);
		}
		else {
			m.addAttribute("msg","no hay registros");
		}
		System.out.println("estoy en Info.Profesionales");
		return "profesionales/displayProfesionales";
		
	}
	// ir a la pagina de actualizacion
	@GetMapping("/editpr/{id}")
	public String profesional4(@PathVariable("id") Optional<Long> id, Model m)
	{
		if(id.isPresent())
		{
			Profesionales Profesionales = prorepo.getOne(id.get());
			m.addAttribute("edata",Profesionales);
		}
		else {
			m.addAttribute("edata", new Profesionales());
		}
		return "profesionales/updateProfesionales";
	}
	//Actualizar registro
	
	@PostMapping("/updatepr/{id}")
	public String profesional5(Profesionales profe, Model m)
	{
		prorepo.save(profe);
		m.addAttribute("data", prorepo.findAll());
		m.addAttribute("msg", " registro actualizado");
		return "profesionales/displayProfesionales";
	}
	
	// borrar registro
	
	@GetMapping("/deletpr/{id}")
	public String profesional6(@PathVariable("id") Long id, Model m)
	{
		prorepo.deleteById(id);
		m.addAttribute("data", prorepo.findAll());
		m.addAttribute("msg", "Registro Borrado");
		return "profesionales/displayProfesionales";
	}

	
	}

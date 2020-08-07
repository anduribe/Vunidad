package com.vunidad.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.vunidad.modelo.Accidentabilidad;
import com.vunidad.repo.AccidentabilidadRepo;


@Controller
@RequestMapping
public class AccidentabilidadController 
{
	
private final AccidentabilidadRepo accirepo;
//creamos un costructor 
public AccidentabilidadController(AccidentabilidadRepo accirepo) 
	{
	this.accirepo = accirepo;
	}




	
	@GetMapping("/insertacci")
	public String accidentabilidad1(Accidentabilidad accidentabilidad)
	{
		return "thymeleaf/accidentabilidad/agregarAccidentabilidad";
	}
	
	@PostMapping("/addacci")
	public String accidentabilidad2(Accidentabilidad tacci, Model m)
	{
		accirepo.save(tacci);
		m.addAttribute("msg", "Agregados Datos de accidentes");
		return "thymeleaf/accidentabilidad/agregarAccidentabilidad";
	}
	
	@GetMapping("/displayaccidentabilidad")
	public String accidentabilidad3(Model m)
	{
		List list = accirepo.findAll();
		if(!list.isEmpty())
		{
			m.addAttribute("data", list);
		}
		else {
			m.addAttribute("msg","no hay registros");
		}
		System.out.println("estoy en Accidentabilidad");
		return "thymeleaf/accidentabilidad/displayAccidentabilidad";
		
	}
	// ir a la pagina de actualizacion
	@GetMapping("/editacci/{id}")
	public String accidentabilidad4(@PathVariable("id") Optional<Long> id, Model m)
	{
		if(id.isPresent())
		{
			Accidentabilidad accidentabilidad = accirepo.getOne(id.get());
			m.addAttribute("edata",accidentabilidad);
		}
		else {
			m.addAttribute("edata", new Accidentabilidad());
		}
		return "thymeleaf/accidentabilidad/updateAccidentabilidad";
	}
	//Actualizar registro
	
	@PostMapping("/updateacci/{id}")
	public String mejora5(Accidentabilidad tacci, Model m)
	{
		accirepo.save(tacci);
		m.addAttribute("data", accirepo.findAll());
		m.addAttribute("msg", " registro actualizado");
		return "thymeleaf/accidentabilidad/displayAccidentabilidad";
	}
	
	// borrar registro
	
	@GetMapping("/deletacci/{id}")
	public String accidentabilidad6(@PathVariable("id") Long id, Model m)
	{
		accirepo.deleteById(id);
		m.addAttribute("data", accirepo.findAll());
		m.addAttribute("msg", "Registro Borrado");
		return "thymeleaf/accidentabilidad/displayAccidentabilidad";
	}

	
	}

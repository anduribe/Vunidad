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

import com.vunidad.modelo.Mejoras;
import com.vunidad.repo.MejorasRepo;


@Controller
@RequestMapping
public class MejorasController 
{
	
private final MejorasRepo mrepo;
//creamos un costructor 
public MejorasController(MejorasRepo mrepo) 
	{
	this.mrepo = mrepo;
	}



//
@RequestMapping("/mejoral")
public ModelAndView mejorDashboard() {
return new ModelAndView("thymeleaf/mejoras/indexmejor");
}
//

	
	
	@GetMapping("/insertm")
	public String mejora1(Mejoras mejoras)
	{
		return "thymeleaf/mejoras/agregarMejoras";
	}
	
	@PostMapping("/addm")
	public String mejora2(Mejoras mejor, Model m)
	{
		mrepo.save(mejor);
		m.addAttribute("msg", "Agregada Mejora");
		return "thymeleaf/mejoras/agregarMejoras";
	}
	
	@GetMapping("/displaymejoras")
	public String mejora3(Model m)
	{
		List list = mrepo.findAll();
		if(!list.isEmpty())
		{
			m.addAttribute("data", list);
		}
		else {
			m.addAttribute("msg","no hay registros");
		}
		System.out.println("estoy en mejoras");
		return "thymeleaf/mejoras/displayMejoras";
		
	}
	// ir a la pagina de actualizacion
	@GetMapping("/editm/{id}")
	public String mejora4(@PathVariable("id") Optional<Long> id, Model m)
	{
		if(id.isPresent())
		{
			Mejoras mejoras = mrepo.getOne(id.get());
			m.addAttribute("edata",mejoras);
		}
		else {
			m.addAttribute("edata", new Mejoras());
		}
		return "thymeleaf/mejoras/updateMejoras";
	}
	//Actualizar registro
	
	@PostMapping("/updatem/{id}")
	public String mejora5(Mejoras mejor, Model m)
	{
		mrepo.save(mejor);
		m.addAttribute("data", mrepo.findAll());
		m.addAttribute("msg", " registro actualizado");
		return "thymeleaf/mejoras/displayMejoras";
	}
	
	// borrar registro
	
	@GetMapping("/deletem/{id}")
	public String mejora6(@PathVariable("id") Long id, Model m)
	{
		mrepo.deleteById(id);
		m.addAttribute("data", mrepo.findAll());
		m.addAttribute("msg", "Registro Borrado");
		return "thymeleaf/mejoras/displayMejoras";
	}

	
	}

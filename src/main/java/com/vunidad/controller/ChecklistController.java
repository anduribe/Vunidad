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

import com.vunidad.modelo.Checklist;
import com.vunidad.repo.ChecklistRepo;


@Controller
@RequestMapping
public class ChecklistController 
{
	
private final ChecklistRepo chrepo;
//creamos un costructor 
public ChecklistController(ChecklistRepo chrepo) 
	{
	this.chrepo = chrepo;
	}




	
	@GetMapping("/insertch")
	public String checklist1(Checklist checklist)
	{
		return "checklist/agregarChecklist";
	}
	
	@PostMapping("/addch")
	public String checklist2(Checklist check, Model m)
	{
		chrepo.save(check);
		m.addAttribute("msg", "Agregada checklist");
		return "Checklist/agregarChecklist";
	}
	
	@GetMapping("/displaychecklist")
	public String checklist3(Model m)
	{
		List list = chrepo.findAll();
		if(!list.isEmpty())
		{
			m.addAttribute("data", list);
		}
		else {
			m.addAttribute("msg","no hay registros");
		}
		System.out.println("estoy en Checklist");
		return "checklist/displayChecklist";
		
	}
	// ir a la pagina de actualizacion
	@GetMapping("/editch/{id}")
	public String checklist4(@PathVariable("id") Optional<Long> id, Model m)
	{
		if(id.isPresent())
		{
			Checklist checklist = chrepo.getOne(id.get());
			m.addAttribute("edata",checklist);
		}
		else {
			m.addAttribute("edata", new Checklist());
		}
		return "checklist/updateChecklist";
	}
	//Actualizar registro
	
	@PostMapping("/updatech/{id}")
	public String checklist5(Checklist check, Model m)
	{
		chrepo.save(check);
		m.addAttribute("data", chrepo.findAll());
		m.addAttribute("msg", " Checklist actualizado");
		return "checklist/displayChecklist";
	}
	
	// borrar registro
	
	@GetMapping("/deletch/{id}")
	public String checklist6(@PathVariable("id") Long id, Model m)
	{
		chrepo.deleteById(id);
		m.addAttribute("data", chrepo.findAll());
		m.addAttribute("msg", "Registro Borrado");
		return "checklist/displayChecklist";
	}

	
	}

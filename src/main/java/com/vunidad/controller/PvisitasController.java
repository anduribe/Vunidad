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

import com.vunidad.modelo.Pvisitas;
import com.vunidad.repo.PvisitasRepo;


@Controller
@RequestMapping
public class PvisitasController 
{
	
private final PvisitasRepo pvrepo;
//creamos un costructor 
public PvisitasController(PvisitasRepo pvrepo) 
	{
	this.pvrepo = pvrepo;
	}




	
	@GetMapping("/insertpv")
	public String pvisitas1(Pvisitas pvisitas)
	{
		return "pvisitas/agregarPvisitas";
	}
	
	@PostMapping("/addpv")
	public String pvisitas2(Pvisitas pvisit, Model m)
	{
		pvrepo.save(pvisit);
		m.addAttribute("msg", "Agregada Visita");
		return "pvisitas/agregarPvisitas";
	}
	
	@GetMapping("/displaypvisitas")
	public String pvisitas3(Model m)
	{
		List list = pvrepo.findAll();
		if(!list.isEmpty())
		{
			m.addAttribute("data", list);
		}
		else {
			m.addAttribute("msg","no hay registros");
		}
		System.out.println("estoy en Planificador de visitas");
		return "pvisitas/displayPvisitas";
		
	}
	// ir a la pagina de actualizacion
	@GetMapping("/editpv/{id}")
	public String pvisitas4(@PathVariable("id") Optional<Long> id, Model m)
	{
		if(id.isPresent())
		{
			Pvisitas pvisitas = pvrepo.getOne(id.get());
			m.addAttribute("edata",pvisitas);
		}
		else {
			m.addAttribute("edata", new Pvisitas());
		}
		return "pvisitas/updatePvisitas";
	}
	//Actualizar registro
	
	@PostMapping("/updatepv/{id}")
	public String mejora5(Pvisitas pvisit, Model m)
	{
		pvrepo.save(pvisit);
		m.addAttribute("data", pvrepo.findAll());
		m.addAttribute("msg", " registro actualizado");
		return "pvisitas/displayPvisitas";
	}
	
	// borrar registro
	
	@GetMapping("/deletpv/{id}")
	public String pvisitas6(@PathVariable("id") Long id, Model m)
	{
		pvrepo.deleteById(id);
		m.addAttribute("data", pvrepo.findAll());
		m.addAttribute("msg", "Registro Borrado");
		return "pvisitas/displayPvisitas";
	}

	
	}

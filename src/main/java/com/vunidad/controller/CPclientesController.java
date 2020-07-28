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

import com.vunidad.modelo.CPclientes;
import com.vunidad.repo.CPclientesRepo;


@Controller
@RequestMapping
public class CPclientesController 
{
	
private final CPclientesRepo cpcrepo;
//creamos un costructor 
public CPclientesController(CPclientesRepo cpcrepo) 
	{
	this.cpcrepo = cpcrepo;	
	}

	
	@GetMapping("/insertcp")
	public String cpcliente1(CPclientes cpclientes)
	{
		return "cpclientes/agregarCPclientes";
	}
	
	@PostMapping("/addcp")
	public String cpcliente2(CPclientes cpclient, Model m)
	{
		cpcrepo.save(cpclient);
		m.addAttribute("msg", "Control Agregado");
		return "cpclientes/agregarCPclientes";
	}
	
	@GetMapping("/displaycpclientes")
	public String cpcliente3(Model m)
	{
		List list = cpcrepo.findAll();
		if(!list.isEmpty())
		{
			m.addAttribute("data", list);
		}
		else {
			m.addAttribute("msg","no hay registros");
		}
		System.out.println("estoy en Control pago Clientes");
		return "cpclientes/displayCPclientes";
		
	}
	// ir a la pagina de actualizacion
	@GetMapping("/editcp/{id}")
	public String cpcliente4(@PathVariable("id") Optional<Long> id, Model m)
	{
		if(id.isPresent())
		{
			CPclientes cpclientes = cpcrepo.getOne(id.get());
			m.addAttribute("edata",cpclientes);
		}
		else {
			m.addAttribute("edata", new CPclientes());
		}
		return "cpclientes/updateCPclientes";
	}
	//Actualizar registro
	
	@PostMapping("/updatecp/{id}")
	public String cpcliente5(CPclientes cpclient, Model m)
	{
		cpcrepo.save(cpclient);
		m.addAttribute("data", cpcrepo.findAll());
		m.addAttribute("msg", " registro pago clientes actualizado");
		return "cpclientes/displayCPclientes";
	}
	
	// borrar registro
	
	@GetMapping("/deletcp/{id}")
	public String cpcliente6(@PathVariable("id") Long id, Model m)
	{
		cpcrepo.deleteById(id);
		m.addAttribute("data", cpcrepo.findAll());
		m.addAttribute("msg", "Registro Borrado");
		return "cpclientes/displayCPclientes";
	}

	
	}

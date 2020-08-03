package com.vunidad.jwt;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@RequestMapping("hola")
	public String helloWorld(@RequestParam(value="name", defaultValue="MUCHACHOS DEL EQUIPO SSL") String name) {
		return "HOLA "+name+"!!";
	}
}

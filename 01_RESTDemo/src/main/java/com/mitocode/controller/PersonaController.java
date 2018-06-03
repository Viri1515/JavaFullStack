package com.mitocode.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.model.Persona;
import com.mitocode.service.IPersonaService;
import com.mitocode.service.PersonaServiceImpl;

@RestController
public class PersonaController {

	// se instancia sin usar spring
	/*
	 * private PersonaServiceImpl service; public PersonaController(){
	 * PersonaServiceImpl service = new PersonaServiceImpl(); }
	 */

	// todo lo anterior se puede sustituir con el autowire inyección de
	// dependencias de spring:
	@Autowired
	private IPersonaService service;

	@GetMapping(value="/listar",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Persona>> listar() {
		List<Persona> personas = new ArrayList<>();
		try {
			personas = service.listar();

		} catch (Exception e) {
			new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<List<Persona>>(personas, HttpStatus.OK);
	}
}

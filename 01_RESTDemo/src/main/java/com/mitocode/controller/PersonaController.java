package com.mitocode.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.model.Persona;
import com.mitocode.service.IPersonaService;
import com.mitocode.service.PersonaServiceImpl;

@RestController
@RequestMapping("/persona")
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

	@GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Persona>> listar() {
		List<Persona> personas = new ArrayList<>();
		try {
			personas = service.listar();

		} catch (Exception e) {
			new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<List<Persona>>(personas, HttpStatus.OK);
	}
	
	@GetMapping(value = "/listarId/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Persona> listarId(@PathVariable("id") Integer id) {
		Persona persona = new Persona();
		try {
			persona = service.listarId(id);

		} catch (Exception e) {
			new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Persona>(persona, HttpStatus.OK);
	}

	@PostMapping(value="/registrar",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> registrar(@RequestBody Persona per) {
		int resultado = 0;
		try {
			service.registrar(per);
			resultado = 1;
		} catch (Exception e) {
			new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Integer>(resultado, HttpStatus.OK);
	}
	
	@PutMapping(value="/actualizar",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> actualizar(@RequestBody Persona per) {
		int resultado = 0;
		try {
			service.modificar(per);
			resultado = 1;
		} catch (Exception e) {
			new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Integer>(resultado, HttpStatus.OK);
	}
	
	
	@DeleteMapping(value="/eliminar/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> eliminar(@PathVariable Integer id) {
		int resultado = 0;
		try {
			service.eliminar(id);
			resultado = 1;
		} catch (Exception e) {
			new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return new ResponseEntity<Integer>(resultado, HttpStatus.OK);
	}
}

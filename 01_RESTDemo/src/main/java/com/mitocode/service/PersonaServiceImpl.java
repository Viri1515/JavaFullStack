package com.mitocode.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mitocode.model.Persona;

@Service
public class PersonaServiceImpl implements IPersonaService{

	@Override
	public void registrar(Persona per) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificar(Persona per) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Persona> listar() {
		List<Persona> lista = new ArrayList<>();
		lista.add(new Persona(1,"viri","reyes",32));
		lista.add(new Persona(2,"dieguito","reyesg",13));
		lista.add(new Persona(3,"Uli","almanza",35));
		return lista;
	}

	@Override
	public Persona listarId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}

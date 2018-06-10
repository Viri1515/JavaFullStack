package com.mitocode.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.dao.IPersonaDAO;
import com.mitocode.model.Persona;

@Service
public class PersonaServiceImpl implements IPersonaService{

	@Autowired
	IPersonaDAO dao;
	
	@Override
	public void registrar(Persona per) {
		dao.save(per);		
	}

	@Override
	public void modificar(Persona per) {
		dao.save(per);
		
	}

	@Override
	public void eliminar(Integer id) {
		dao.delete(id);
	}

	@Override
	public List<Persona> listar() {
		return dao.findAll();
	}

	@Override
	public Persona listarId(Integer id) {
		return dao.findOne(id);
	}

}

package com.mitocode.model;

public class Persona {

	private int idPersona;
	private String Nombres;
	private String Apellidos;
	private int edad;

	public Persona(){}
	
	public Persona(int i, String string, String string2, int j) {
		// TODO Auto-generated constructor stub
		this.idPersona=i;
		this.Nombres=string;
		this.Apellidos=string2;
		this.edad=j;
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombres() {
		return Nombres;
	}

	public void setNombres(String nombres) {
		Nombres = nombres;
	}

	public String getApellidos() {
		return Apellidos;
	}

	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

}

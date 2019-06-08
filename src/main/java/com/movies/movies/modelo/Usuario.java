package com.movies.movies.modelo;

import com.movies.movies.gestor.GestorUsuario;

public class Usuario {
	
	private Integer id;
	private String nombre;
	private String documento;
	private Historial historial;
	
	public Usuario() { }
	
	public Usuario(String nombre, String documento) {
		super();
		this.nombre = nombre;
		this.documento = documento;
		this.historial = new Historial();	
	}
	
	public Boolean esAntiguo() {
		return GestorUsuario.instancia().esAntiguo(this);
	}
	
	public Boolean algoInteresante() {
		return GestorUsuario.instancia().algoInteresante(this);
	}
	
	public Boolean estadoAnimo() {
		return GestorUsuario.instancia().esAntiguo(this);
	}
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDocumento() {
		return documento;
	}


	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public Historial getHistorial() {
		return historial;
	}

	public void setHistorial(Historial historial) {
		this.historial = historial;
	}

}

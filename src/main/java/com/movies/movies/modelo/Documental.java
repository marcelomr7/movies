package com.movies.movies.modelo;

import java.util.Date;

public class Documental extends Producto {
	
	public Documental(String nombre, Date estreno, Double duracion) {
		super(nombre, estreno, duracion, TipoProducto.DOCUMENTAL);
	}
	
	@Override
	public Boolean esInteresante() {
		return getTitulo().toLowerCase().indexOf("unofficial")>0 ? true : false;
	}

}

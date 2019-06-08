package com.movies.movies.modelo;

import java.util.Date;

public class Pelicula extends Producto {
	
	private Integer cantidadOscar;
	
	public Pelicula(String nombre, Date estreno, Double duracion, Integer cantidadOscar) {
		super(nombre, estreno, duracion, TipoProducto.PELICULA);
		this.cantidadOscar = cantidadOscar;
	}

	@Override
	public Boolean esInteresante() {
		return cantidadOscar>=1;
	}

	public Integer getCantidadOscar() {
		return cantidadOscar;
	}

	public void setCantidadOscar(Integer cantidadOscar) {
		this.cantidadOscar = cantidadOscar;
	}
	
}

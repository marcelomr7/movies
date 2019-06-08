package com.movies.movies.modelo;

import java.util.Date;

public class Serie extends Producto {
	
	private Integer cantidadTemporadas;
	
	public Serie(String nombre, Date estreno, Double duracion, Integer cantidadOscar) {
		super(nombre, estreno, duracion, TipoProducto.SERIE);
		this.cantidadTemporadas = cantidadOscar;
	}

	@Override
	public Boolean esInteresante() {
		return cantidadTemporadas>=4;
	}

	public Integer getCantidadTemporadas() {
		return cantidadTemporadas;
	}

	public void setCantidadTemporadas(Integer cantidadTemporadas) {
		this.cantidadTemporadas = cantidadTemporadas;
	}
	
}

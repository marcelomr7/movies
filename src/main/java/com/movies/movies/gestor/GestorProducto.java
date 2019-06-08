package com.movies.movies.gestor;

import java.util.Date;

import com.movies.movies.modelo.Documental;
import com.movies.movies.modelo.Pelicula;
import com.movies.movies.modelo.Producto;
import com.movies.movies.modelo.Serie;
import com.movies.movies.utils.Utils;

public class GestorProducto {
	
	private static GestorProducto instancia;
	
	public static GestorProducto instancia() {
		if (instancia == null)
			instancia = new GestorProducto();
		return instancia;
	}
	
	public Documental generarDocumental(String nombre, Date estreno, Double duracion) {
		return new Documental(nombre, estreno, duracion);
	}
	
	public Pelicula generarPelicula(String nombre, Date estreno, Double duracion, Integer cantidadOscar) {
		return  new Pelicula(nombre, estreno, duracion, cantidadOscar);
	}
	
	public Serie generarSerie(String nombre, Date estreno, Double duracion, Integer cantidadOscar) {
		return new Serie(nombre, estreno, duracion, cantidadOscar);
	}
	
	public Boolean esViejo(Producto producto) {
		return producto.getEstreno().before(Utils.menosAnios(2));
	}
	
}

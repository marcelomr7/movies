package com.movies.movies.modelo;

import java.util.ArrayList;
import java.util.List;

public class Historial {
	
	private List<Producto> series = new ArrayList<Producto>();
	private List<Producto> peliculas = new ArrayList<Producto>();
	private List<Producto> documentales = new ArrayList<Producto>();
	
	public Historial() { }
	
	public List<Producto> getProductos() {
		final List<Producto> productos = new ArrayList<Producto>();
		productos.addAll(series);
		productos.addAll(peliculas);
		productos.addAll(documentales);

		return productos;
	}

	public List<Producto> getSeries() {
		return series;
	}

	public void setSeries(List<Producto> series) {
		this.series = series;
	}

	public List<Producto> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(List<Producto> peliculas) {
		this.peliculas = peliculas;
	}

	public List<Producto> getDocumentales() {
		return documentales;
	}

	public void setDocumentales(List<Producto> documentales) {
		this.documentales = documentales;
	}

}

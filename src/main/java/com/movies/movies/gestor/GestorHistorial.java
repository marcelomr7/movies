package com.movies.movies.gestor;


import com.movies.movies.modelo.Historial;
import com.movies.movies.modelo.Producto;

public class GestorHistorial {
	
	private static GestorHistorial instancia;
	
	public static GestorHistorial instancia() {
		if (instancia == null)
			instancia = new GestorHistorial();
		return instancia;
	}
	
	public void agregarProducto(Producto producto, Historial historial) {
		switch (producto.getTipo()) {
		case DOCUMENTAL:
			historial.getDocumentales().add(producto);
			break;
		case PELICULA:
			historial.getPeliculas().add(producto);
			break;
		case SERIE:
			historial.getSeries().add(producto);
			break;
		default:
			break;
		}
	}
	
	public void limpiarHistorial(Historial historial) {
		historial.getDocumentales().clear();
		historial.getPeliculas().clear();
		historial.getSeries().clear();
	}
}

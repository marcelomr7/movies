package com.movies.movies.gestor;

import java.util.stream.Collectors;

import com.movies.movies.modelo.Producto;
import com.movies.movies.modelo.Usuario;

public class GestorUsuario {
	
	private static GestorUsuario instancia;
	
	public static GestorUsuario instancia() {
		if (instancia == null)
			instancia = new GestorUsuario();
		return instancia;
	}
	
	public Usuario generarUsuario(String nombre, String documento) {
		final Usuario usuario = new Usuario(nombre, documento);
		return usuario;
	}
	
	public Boolean esAntiguo(Usuario usuario) {
		return !usuario.getHistorial().getProductos().stream()
					.filter(Producto::esViejo)
						.collect(Collectors.toList()).isEmpty();
	}
	
	public Boolean algoInteresante(Usuario usuario) {
		return !usuario.getHistorial().getProductos().stream()
					.filter(Producto::esInteresante)
						.collect(Collectors.toList()).isEmpty();
	}
	
}

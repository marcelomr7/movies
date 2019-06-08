package com.movies.movies.datos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.movies.movies.gestor.GestorHistorial;
import com.movies.movies.gestor.GestorProducto;
import com.movies.movies.gestor.GestorUsuario;
import com.movies.movies.modelo.Catalogo;
import com.movies.movies.modelo.Producto;
import com.movies.movies.modelo.Usuario;
import com.movies.movies.utils.Utils;

public class CargarDatos {
	private final static String  NOMBRE_DOCUMENTAL = "DOCUMENTAL";
	private final static String  NOMBRE_SERIE = "SERIE";
	private final static String  NOMBRE_PELICULA = "PELICULA";
	private final static Date    ESTRENO_NUEVO = new Date();
	private final static Date    ESTRENO_VIEJO = Utils.menosAnios(4);
	public final static  Date 	 ESTRENO_15_A = Utils.menosAnios(15);
	private final static Double  DURACION_CORTA = 1D;
	private final static Double  DURACION_LARGA = 3D;
	private final static Integer OSCAR0 = 0;
	private final static Integer OSCAR2 = 2;
	private final static Integer TEMPORADA3 = 3;
	private final static Integer TEMPORADA5 = 5;


	public Catalogo catalogo = new Catalogo();
	public  List<Usuario> usuarios = new ArrayList<Usuario>();
	private List<Producto> productos = new ArrayList<Producto>();

	
	public CargarDatos() {
		cargarUsuarios();
	}
	
	public void cargarUsuarios() {
		usuarios.add(GestorUsuario.instancia().generarUsuario("Marcelo", "11111111"));
		usuarios.add(GestorUsuario.instancia().generarUsuario("Flora", "22222222"));
		usuarios.add(GestorUsuario.instancia().generarUsuario("Ian", "33333333"));
	}
	
	
	public void cargarProductos() {
			
		productos.clear();
		productos.add(GestorProducto.instancia().generarDocumental("aunofficiala", ESTRENO_NUEVO, DURACION_CORTA));
		productos.add(GestorProducto.instancia().generarDocumental(NOMBRE_DOCUMENTAL+1, ESTRENO_VIEJO, DURACION_LARGA));
		
		productos.add(GestorProducto.instancia().generarPelicula(NOMBRE_PELICULA+1, ESTRENO_NUEVO, DURACION_CORTA, OSCAR0));
		productos.add(GestorProducto.instancia().generarPelicula(NOMBRE_PELICULA+2, ESTRENO_VIEJO, DURACION_LARGA, OSCAR2));
		
		productos.add(GestorProducto.instancia().generarSerie(NOMBRE_SERIE+1, ESTRENO_NUEVO, DURACION_CORTA, TEMPORADA5));
		productos.add(GestorProducto.instancia().generarSerie(NOMBRE_SERIE+2, ESTRENO_VIEJO, DURACION_LARGA, TEMPORADA3));
		
		productos.add(GestorProducto.instancia().generarPelicula("EL REY LEON", ESTRENO_15_A, DURACION_CORTA, OSCAR0));

		catalogo.setProductos(productos);
		
	}
	
	public void cargarProductosNuevos() {
		productos.clear();
		productos.add(GestorProducto.instancia().generarDocumental("aunofficiala", ESTRENO_NUEVO, DURACION_CORTA));
		productos.add(GestorProducto.instancia().generarPelicula(NOMBRE_PELICULA+1, ESTRENO_NUEVO, DURACION_CORTA, OSCAR0));
		productos.add(GestorProducto.instancia().generarSerie(NOMBRE_SERIE+1, ESTRENO_NUEVO, DURACION_CORTA, TEMPORADA5));
		catalogo.setProductos(productos);
		
		cargarHistorial();
	}
	
	public void cargarProductosViejos() {
		productos.clear();
		productos.add(GestorProducto.instancia().generarDocumental(NOMBRE_DOCUMENTAL+1, ESTRENO_VIEJO, DURACION_LARGA));
		productos.add(GestorProducto.instancia().generarPelicula(NOMBRE_PELICULA+2, ESTRENO_VIEJO, DURACION_LARGA, OSCAR2));
		productos.add(GestorProducto.instancia().generarSerie(NOMBRE_SERIE+2, ESTRENO_VIEJO, DURACION_LARGA, TEMPORADA3));
		
		catalogo.setProductos(productos);
		
		cargarHistorial();
	}
	
	public void cargarProductosInteresantes() {
		productos.clear();
		productos.add(GestorProducto.instancia().generarDocumental("aunofficiala", ESTRENO_NUEVO, DURACION_CORTA));
		productos.add(GestorProducto.instancia().generarPelicula(NOMBRE_PELICULA+2, ESTRENO_VIEJO, DURACION_LARGA, OSCAR2));
		productos.add(GestorProducto.instancia().generarSerie(NOMBRE_SERIE+1, ESTRENO_NUEVO, DURACION_CORTA, TEMPORADA5));
		
		catalogo.setProductos(productos);
		
		cargarHistorial();
	}
	
	public void cargarProductosNoInteresantes() {
		productos.clear();
		productos.add(GestorProducto.instancia().generarDocumental(NOMBRE_DOCUMENTAL+1, ESTRENO_VIEJO, DURACION_LARGA));
		productos.add(GestorProducto.instancia().generarPelicula(NOMBRE_PELICULA+1, ESTRENO_NUEVO, DURACION_CORTA, OSCAR0));
		productos.add(GestorProducto.instancia().generarSerie(NOMBRE_SERIE+2, ESTRENO_VIEJO, DURACION_LARGA, TEMPORADA3));
		
		catalogo.setProductos(productos);
		
		cargarHistorial();
	}
	
	public void cargarHistorial() {
		usuarios.forEach(u->GestorHistorial.instancia().limpiarHistorial(u.getHistorial()));
		GestorHistorial.instancia().agregarProducto(productos.get(0), usuarios.get(0).getHistorial());
		GestorHistorial.instancia().agregarProducto(productos.get(1), usuarios.get(1).getHistorial());
		GestorHistorial.instancia().agregarProducto(productos.get(2), usuarios.get(2).getHistorial());
	}
}

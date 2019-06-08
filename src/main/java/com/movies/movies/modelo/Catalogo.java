package com.movies.movies.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.movies.movies.utils.Utils;

public class Catalogo {
	private List<Producto> productos = new ArrayList<Producto>();
	
	public List<Producto> getSeries() {
		return productos.stream().filter(p-> p.getTipo() == TipoProducto.SERIE).collect(Collectors.toList());
	}

	public List<Producto> getPeliculas() {
		return productos.stream().filter(p-> p.getTipo() == TipoProducto.PELICULA).collect(Collectors.toList());
	}

	public List<Producto> getDocumentales() {
		return productos.stream().filter(p-> p.getTipo() == TipoProducto.DOCUMENTAL).collect(Collectors.toList());
	}

	public Catalogo() { }
	
	public Catalogo(List<Producto> productos) {
		super();
		this.productos = productos;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	public List<Producto> getPeliculasViejas() {
		return getPeliculas().stream()
			.filter(Producto::esViejo)
				.collect(Collectors.toList());
	}
	
	public List<Producto> getPeliculasNuevas() {
		return getPeliculas().stream()
			.filter(p->!p.esViejo())
				.collect(Collectors.toList());
	}
	
	public List<Producto> getSeriesViejas() {
		return getSeries().stream()
			.filter(Producto::esViejo)
				.collect(Collectors.toList());
	}
	
	public List<Producto> getSeriesNuevas() {
		return getSeries().stream()
				.filter(p->!p.esViejo())
					.collect(Collectors.toList());
	}
	
	public List<Producto> getDocumentalesViejas() {
		return getSeries().stream()
			.filter(Producto::esViejo)
				.collect(Collectors.toList());
	}
	
	public List<Producto> getDocumentalesNuevas() {
		return getSeries().stream()
				.filter(p->!p.esViejo())
					.collect(Collectors.toList());
	}
	
	public List<Producto> getPeliculasPorEstadoAnimo(EstadoAnimo animo) {
		switch (animo) {
		case TRISTE:
			return getPeliculasLargas();
		case MELANCOLICO:
			return getPeliculasMayoresDe10Anios();
		default:
			return getPeliculas();
		}
	}
	
	public List<Producto> getPeliculasCortas() {
		return getPeliculas().stream()
				.filter(p->p.getDuracion() <= 2D)
					.collect(Collectors.toList());
	}
	
	public List<Producto> getPeliculasLargas() {
		return getPeliculas().stream()
				.filter(p->p.getDuracion() > 2D)
					.collect(Collectors.toList());
	}
	
	public List<Producto> getPeliculasMayoresDe10Anios() {
		return getPeliculas().stream()
				.filter(p->p.getEstreno().before(Utils.menosAnios(10)))
					.collect(Collectors.toList());
	}
	
	public List<Producto> getDocumentalesCortas() {
		return getDocumentales().stream()
				.filter(p->p.getDuracion() <= 2D)
					.collect(Collectors.toList());
	}
	
	public List<Producto> getDocumentalesLargas() {
		return getDocumentales().stream()
				.filter(p->p.getDuracion() > 2D)
					.collect(Collectors.toList());
	}
	
	public List<Producto> getDocumentalesMayoresDe10Anios() {
		return getDocumentales().stream()
				.filter(p->p.getEstreno().before(Utils.menosAnios(10)))
					.collect(Collectors.toList());
	}
	
	public List<Producto> getSeriesCortas() {
		return getSeries().stream()
				.filter(p->p.getDuracion() <= 2D)
					.collect(Collectors.toList());
	}
	
	public List<Producto> getSeriesLargas() {
		return getSeries().stream()
				.filter(p->p.getDuracion() > 2D)
					.collect(Collectors.toList());
	}
	
	public List<Producto> getSeriesMayoresDe10Anios() {
		return getSeries().stream()
				.filter(p->p.getEstreno().before(Utils.menosAnios(10)))
					.collect(Collectors.toList());
	}
	
}

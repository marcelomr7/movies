package com.movies.movies.modelo;

import java.util.Date;

import com.movies.movies.gestor.GestorProducto;

public class Producto implements Interesante
{
	
	private Integer id;
	private String titulo;
	private Date estreno;
	private Double duracion;
	private TipoProducto tipo;
	
	
	public Producto() {}
	
	public Producto(String nombre, Date estreno, Double duracion) {
		super();
		this.titulo = nombre;
		this.estreno = estreno;
		this.duracion = duracion;
	}
	
	public Producto(String nombre, Date estreno, Double duracion, TipoProducto tipo) {
		this(nombre, estreno, duracion);
		this.tipo = tipo;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Date getEstreno() {
		return estreno;
	}
	public void setEstreno(Date estreno) {
		this.estreno = estreno;
	}
	public Double getDuracion() {
		return duracion;
	}
	public void setDuracion(Double duracion) {
		this.duracion = duracion;
	}

	public TipoProducto getTipo() {
		return tipo;
	}

	public void setTipo(TipoProducto tipo) {
		this.tipo = tipo;
	}
	
	public Boolean esViejo() {
		return GestorProducto.instancia().esViejo(this);
	}

	@Override
	public Boolean esInteresante() {
		return false;
	}
	
}

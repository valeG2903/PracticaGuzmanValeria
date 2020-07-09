package com.redsocial.entidad;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Revista {
	
	private int idRevista;
	
	private String nombre;
	
	private double precio;
	
	private String serie;
	
	private String categoria;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaLanzamiento;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date fechaEdicion;
	
	private Categoria idcategoria;

	public int getIdRevista() {
		return idRevista;
	}

	public void setIdRevista(int idRevista) {
		this.idRevista = idRevista;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Date getFechaLanzamiento() {
		return fechaLanzamiento;
	}

	public void setFechaLanzamiento(Date fechaLanzamiento) {
		this.fechaLanzamiento = fechaLanzamiento;
	}

	public Date getFechaEdicion() {
		return fechaEdicion;
	}

	public void setFechaEdicion(Date fechaEdicion) {
		this.fechaEdicion = fechaEdicion;
	}

	public Categoria getIdcategoria() {
		return idcategoria;
	}

	public void setIdcategoria(Categoria idcategoria) {
		this.idcategoria = idcategoria;
	}
	
	
}

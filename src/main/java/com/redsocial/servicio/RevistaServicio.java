package com.redsocial.servicio;

import java.util.List;

import com.redsocial.entidad.Revista;

public interface RevistaServicio {

	public List<Revista> listaRevista(int idCategoria, String string);
	public List<Revista> listaRevistaPorNombre(String string);
	public Revista insertaActualizaRevista(Revista obj);
	public void eliminaRevista(int id);
	public List<Revista> listaRevista();

}

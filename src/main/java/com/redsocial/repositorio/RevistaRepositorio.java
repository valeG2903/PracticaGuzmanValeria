package com.redsocial.repositorio;

import java.util.List;

import com.redsocial.entidad.Revista;

public interface RevistaRepositorio {

	public void eliminaRevista(int idRevista);
	public List<Revista> listaRevista();
	public List<Revista> listaRevistaPorNombre(String nom);
	public List<Revista> listaRevista(int idCategoria, String nombre);
	public Revista insertaActualizaRevista(Revista obj);

}

package com.redsocial.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.redsocial.entidad.Revista;
import com.redsocial.repositorio.RevistaRepositorio;

@Service
public class RevistaServicioImpl implements RevistaServicio{
	
	@Autowired
	private RevistaRepositorio repositorio;
	
	@Override
	public Revista insertaActualizaRevista(Revista obj) {
		return repositorio.insertaActualizaRevista(obj);
	}

	@Override
	public void eliminaRevista(int idRevista) {
		repositorio.eliminaRevista(idRevista);
	}

	@Override
	public List<Revista> listaRevista() {
		return repositorio.listaRevista();
	}

	@Override
	public List<Revista> listaRevistaPorNombre(String nom) {
		return repositorio.listaRevistaPorNombre(nom);
	}

	@Override
	public List<Revista> listaRevista(int idCategoria, String nombre) {
	   return repositorio.listaRevista(idCategoria, nombre);
	} 

}


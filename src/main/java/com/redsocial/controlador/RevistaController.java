package com.redsocial.controlador;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.redsocial.entidad.Revista;
import com.redsocial.servicio.CategoriaServicio;
import com.redsocial.servicio.RevistaServicio;
import com.redsocial.entidad.Categoria;

@Controller
public class RevistaController {

	@Autowired
	private RevistaServicio revistaServicio;
	
	@Autowired
	private CategoriaServicio categoriaServicio;
	
	@RequestMapping("/verRevista")
	public String ver() {
		return "registraRevista";
	}
	
	 @RequestMapping("/cargaCategoria")
	 @ResponseBody
	 public List<Categoria> listaCategoria(){
		 return categoriaServicio.listaCategoria();
	 }
	 
	 @RequestMapping("/registraRevista")
	 public String metRegistra(Revista obj,HttpSession session) {
		 Revista aux = revistaServicio.insertaActualizaRevista(obj);
		 if(aux == null) {
				session.setAttribute("MENSAJE", "Registro erróneo");
			}else {
				session.setAttribute("MENSAJE", "Registro exitos");
			}
		 return "redirect:verRevista";
	 }
}


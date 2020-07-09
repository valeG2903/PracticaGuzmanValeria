package com.redsocial.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.redsocial.entidad.Revista;
import com.redsocial.servicio.RevistaServicio;

@Controller
public class RevistaCrudController {
	
	@Autowired
	private RevistaServicio servicio;
	
	@RequestMapping("verCrudRevista")
	public String ver() {
		return "crudRevista";
	}
	
	@RequestMapping("/consultaCrudRevista")
	public String lista(String filtro, Model r) {
		List<Revista> lista = servicio.listaRevistaPorNombre(filtro+"%");
		r.addAttribute("Revista",lista);
		return "crudRevista";
	}
	
	@RequestMapping("/registraActualizaCrudRevista")
	public String registraActualiza(Revista obj, Model r) {
		servicio.insertaActualizaRevista(obj);
		List<Revista> lista = servicio.listaRevista();
		r.addAttribute("Revista", lista);
		return "crudRevista";
	}
	@RequestMapping("/eliminaCrudRevista")
	public String elimina(int id, Model r) {
		servicio.eliminaRevista(id);
		List<Revista> lista =  servicio.listaRevista();
		r.addAttribute("revistas", lista);
		return "crudRevista";
	}
}


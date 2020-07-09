package com.redsocial.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.redsocial.entidad.Revista;
import com.redsocial.servicio.RevistaServicio;
@Controller
public class RevistaConsultaController {
	
	@Autowired
	private RevistaServicio servicio;
		
		@RequestMapping("/verConsultaRevista")
		public String ver() {
			return "consultaRevista";
		}
		
		@RequestMapping("/consultaRevista")
		public String lista(int idCategoria,String nombre,Model r) {
			List<Revista> lista= servicio.listaRevista(idCategoria,nombre+"%");
			r.addAttribute("revistas",lista);
			return "consultaRevista";
	}
}

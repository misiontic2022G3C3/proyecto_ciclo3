/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.web.control;

import com.app.web.servicio.HistoriaServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author Ferney
 */
@Controller
public class HistoriaControlador {
    @Autowired
	private HistoriaServicios hservicio;
        
	@GetMapping("/pacientes/historias")
	public String listarHistorias(Model modelo, @Param("palabraClave") String palabraClave) {
		modelo.addAttribute("historias", hservicio.listarTodosLasHistorias(palabraClave));
		modelo.addAttribute("palabraClave", palabraClave);
		return "historias";
	}
        
        @GetMapping("/pacientes/historias/consultar/{id}")
	public String mostrarFormularioConsultar(@PathVariable Long id, Model modelo){
	        modelo.addAttribute("historia", hservicio.obtenerHistoriaPorId(id));
		return "consultarHistoria";
	}
}

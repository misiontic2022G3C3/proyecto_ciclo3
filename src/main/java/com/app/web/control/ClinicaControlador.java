/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.web.control;

import com.app.web.servicio.ClinicaServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Ferney
 */
@Controller
public class ClinicaControlador {
    	@Autowired
	private ClinicaServicios servicio;
	
	@GetMapping("/Clinicas")
	public String listarClinica(Model modelo) {
		modelo.addAttribute("clinicas", servicio.listarTodasLasClinicas());
		return "clinicas";
	}
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.web.control;

import com.app.web.entidad.Clinicas;
import com.app.web.entidad.Pacientes;
import com.app.web.entidad.Rol;
import com.app.web.servicio.ClinicaServicios;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ferney
 */
@Controller
public class ClinicaControlador {
    	@Autowired
	private ClinicaServicios cservicio;
    
        /*@GetMapping(value={"/login"})
	public String IniciarSesion() {
		return "login";
	}
        */
        @GetMapping(value={"/login"})
	public String IniciarSesion() {
		return "login";
	}
        
        @GetMapping(value={"/"})
	public String paginaInicio() {
		return "index";
	}
        
        @GetMapping("/home")
	public String listarClinica( Model modelo) {
                Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		modelo.addAttribute("clinicas", cservicio.obtenerClinicaPorUsername(auth.getName()));
		return "home";
	}
        
        @GetMapping("/home/editar/{id}")
	public String mostrarFormularioEditar(@PathVariable Long id, Model modelo){
	        modelo.addAttribute("clinicas", cservicio.obtenerClinicaPorId(id));
		return "editarClinica";
	}    
        
	@PostMapping("home/{id}")
	public String actualizarClinica(@PathVariable Long id, 
		@ModelAttribute("clinica") Clinicas clinica, Model model){
		Clinicas clinicaExiste = cservicio.obtenerClinicaPorId(id);
		clinicaExiste.setId(id);
                clinicaExiste.setNit(clinica.getNit());
		clinicaExiste.setRazon_social(clinica.getRazon_social());
                clinicaExiste.setEmail(clinica.getEmail());
		clinicaExiste.setDireccion(clinica.getDireccion());
                clinicaExiste.setUsername(clinica.getUsername());
		clinicaExiste.setEmail(clinica.getEmail());
                clinicaExiste.setPassword(clinica.getPassword());
                clinicaExiste.setRoles(Arrays.asList(new Rol("ROLE_USER")));
                
		cservicio.actualizarClinica(clinicaExiste);
		return "redirect:/logout";
	}
	
	@GetMapping("home/{id}")
	public String eliminarClinica(@PathVariable Long id){
		cservicio.eliminarClinica(id);
		return "redirect:/logout";
	}


}

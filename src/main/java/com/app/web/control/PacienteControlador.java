/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.web.control;

import com.app.web.dto.PacienteRegistroDTO;
import com.app.web.entidad.HistoriasClinicas;
import com.app.web.entidad.Pacientes;
import com.app.web.servicio.ClinicaServicios;
import com.app.web.servicio.PacienteServicios;
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

/**
 *
 * @author Ferney
 */
@Controller
public class PacienteControlador {

	@Autowired
	private PacienteServicios pservicio;

        @Autowired
	private ClinicaServicios cservicio; 
        
        
	@GetMapping("/pacientes")
	public String listarPacientes(Model modelo, @Param("palabraClave") String palabraClave) {
		modelo.addAttribute("pacientes", pservicio.listarTodosLosPacientes(palabraClave));
		modelo.addAttribute("palabraClave", palabraClave);
		return "pacientes";
	}
	
	@GetMapping("/pacientes/editar/{id}")
	public String mostrarFormularioEditar(@PathVariable Long id, Model modelo){
		modelo.addAttribute("pacientes", pservicio.obtenerPacientePorId(id));
		return "editarPaciente";
	}    
        
	@PostMapping("pacientes/{id}")
	public String actualizarPaciente(@PathVariable Long id, 
		@ModelAttribute("paciente") Pacientes paciente, Model model){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
                Pacientes pacienteExiste = pservicio.obtenerPacientePorId(id);
		pacienteExiste.setId(id);
                pacienteExiste.setDocumento(paciente.getDocumento());
		pacienteExiste.setNombre(paciente.getNombre());
                pacienteExiste.setApellido(paciente.getApellido());
		pacienteExiste.setFechaNacimiento(paciente.getFechaNacimiento());
                pacienteExiste.setTelefono(paciente.getTelefono());
		pacienteExiste.setEmail(paciente.getEmail());
                pacienteExiste.setTipoSangre(paciente.getTipoSangre());
                pacienteExiste.setNombreAcudiente(paciente.getNombreAcudiente());
                pacienteExiste.setTelefonoAcudiente(paciente.getTelefonoAcudiente());
                pacienteExiste.setClinica(cservicio.obtenerClinicaPorUsername(auth.getName()));
		pservicio.actualizarPaciente(pacienteExiste);
		return "redirect:/pacientes";
	}
	
	@GetMapping("pacientes/{id}")
	public String eliminarUsuario(@PathVariable Long id){
		pservicio.eliminarPaciente(id);
		return "redirect:/pacientes";
	}

        @GetMapping("/pacientes/consultar/{id}")
	public String mostrarFormularioConsultar(@PathVariable Long id, Model modelo){
	        modelo.addAttribute("paciente", pservicio.obtenerPacientePorId(id));
		return "consultarPaciente";
	}

}

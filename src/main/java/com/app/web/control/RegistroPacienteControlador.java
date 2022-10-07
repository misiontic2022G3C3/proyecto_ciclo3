/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.web.control;

import com.app.web.dto.ClinicaRegistroDTO;
import com.app.web.dto.PacienteRegistroDTO;
import com.app.web.servicio.ClinicaServicios;
import com.app.web.servicio.PacienteServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Ferney
 */

@Controller
@RequestMapping("/pacientes/registroPaciente")
public class RegistroPacienteControlador {
    
    @Autowired
    private PacienteServicios pservicio;
    
    @ModelAttribute("paciente")
	public PacienteRegistroDTO retornarNuevoPacienteRegistroDTO() {
		return new PacienteRegistroDTO();
	}
       
    @GetMapping
    public String mostrarFormularioDeRegistro(){
        return "registroPaciente";
    }
    
    @PostMapping
    public String registarNuevoPaciente(@ModelAttribute("paciente") PacienteRegistroDTO registroDTO){
        pservicio.guardarPaciente(registroDTO);
        return "redirect:/pacientes/registroPaciente?exito";
            
    }
    
}

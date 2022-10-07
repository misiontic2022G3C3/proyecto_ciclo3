/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.web.control;

import com.app.web.dto.HistoriaRegistroDTO;
import com.app.web.dto.PacienteRegistroDTO;
import com.app.web.entidad.HistoriasClinicas;
import com.app.web.servicio.HistoriaServicios;
import com.app.web.servicio.PacienteServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Ferney
 */
@Controller
@RequestMapping("/pacientes/registroHistoria")
public class RegistroHistoriaControlador {
    
    @Autowired
    private HistoriaServicios hservicio;
    
    @ModelAttribute("historia")
	public HistoriaRegistroDTO retornarNuevoHistoriaRegistroDTO() {
		return new HistoriaRegistroDTO();
	}
       
    @GetMapping
    public String mostrarFormularioDeRegistro(){
        return "registroHistoria";
    }
    
    @PostMapping
    public String registarNuevaHistoria(@ModelAttribute("historia") HistoriaRegistroDTO registroDTO){
        hservicio.guardarHistoria(registroDTO);
        return "redirect:/pacientes/registroHistoria?exito";
    }
}

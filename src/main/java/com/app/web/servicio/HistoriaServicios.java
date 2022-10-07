/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.app.web.servicio;


import com.app.web.dto.HistoriaRegistroDTO;
import com.app.web.entidad.HistoriasClinicas;
import java.util.List;

/**
 *
 * @author Ferney
 */
public interface HistoriaServicios {
    
    public List<HistoriasClinicas> listarTodosLasHistorias(String palabraClave); 
	
	//public Pacientes guardarPaciente(Pacientes paciente);
        public HistoriasClinicas guardarHistoria(HistoriaRegistroDTO registroDTO);
	
	public HistoriasClinicas obtenerHistoriaPorId(Long id);
	
}

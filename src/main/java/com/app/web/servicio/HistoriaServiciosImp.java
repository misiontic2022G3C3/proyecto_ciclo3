/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.web.servicio;

import com.app.web.dto.HistoriaRegistroDTO;
import com.app.web.dto.PacienteRegistroDTO;
import com.app.web.entidad.HistoriasClinicas;
import com.app.web.repositorio.HistoriaRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ferney
 */
@Service
public class HistoriaServiciosImp implements HistoriaServicios{
    @Autowired
	private ClinicaServicios cservicio;    
    
        @Autowired
	private HistoriaRepositorio hrepositorio;

	@Override
	public List<HistoriasClinicas> listarTodosLasHistorias(String palabraClave) {
		if(palabraClave != null) {
			return hrepositorio.findAll(palabraClave);
		}
		return hrepositorio.findAll();
	}

        
        @Override
        public HistoriasClinicas guardarHistoria(HistoriaRegistroDTO registroDTO) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();    
            HistoriasClinicas historia = new HistoriasClinicas(registroDTO.getFecha_consulta(),
                registroDTO.getDocumento_paciente(), registroDTO.getEspecialidad(),
                registroDTO.getTemperatura(), registroDTO.getDiagnostico(),
                cservicio.obtenerClinicaPorUsername(auth.getName()));
                return hrepositorio.save(historia);    
    }
        
	@Override
	public HistoriasClinicas obtenerHistoriaPorId(Long id) {
		return hrepositorio.findById(id).get();
	}
}

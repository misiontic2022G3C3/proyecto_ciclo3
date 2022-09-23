/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.web.servicio;

import com.app.web.entidad.Clinicas;
import com.app.web.repositorio.ClinicaRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Ferney
 */
@Service
public class ClinicaServiciosImp implements ClinicaServicios{
    	@Autowired
	private ClinicaRepositorio repositorio;

	@Override
	public List<Clinicas> listarTodasLasClinicas() {
		return repositorio.findAll();
	}

}

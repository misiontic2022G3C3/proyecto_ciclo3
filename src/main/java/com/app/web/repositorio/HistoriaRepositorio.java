/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.app.web.repositorio;

import com.app.web.entidad.HistoriasClinicas;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Ferney
 */
@Repository
public interface HistoriaRepositorio extends JpaRepository<HistoriasClinicas, Long>{
        @Query(value ="SELECT * FROM historias u WHERE (u.especialidad LIKE %?1% OR u.diagnostico LIKE %?1%)", nativeQuery = true)
	public List<HistoriasClinicas> findAll(String palabraClave);
}

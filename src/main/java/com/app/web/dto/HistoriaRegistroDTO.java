package com.app.web.dto;

import java.util.Date;
import javax.persistence.Column;
import org.springframework.format.annotation.DateTimeFormat;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ferney
 */
public class HistoriaRegistroDTO {
     private Long id;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha_consulta;

    private long documento_paciente;
    

    private String especialidad;

    private float temperatura; 
        

    private String diagnostico;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha_consulta() {
        return fecha_consulta;
    }

    public void setFecha_consulta(Date fecha_consulta) {
        this.fecha_consulta = fecha_consulta;
    }

    public long getDocumento_paciente() {
        return documento_paciente;
    }

    public void setDocumento_paciente(long documento_paciente) {
        this.documento_paciente = documento_paciente;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public HistoriaRegistroDTO(Date fecha_consulta, long documento_paciente, String especialidad, float temperatura, String diagnostico) {
        this.fecha_consulta = fecha_consulta;
        this.documento_paciente = documento_paciente;
        this.especialidad = especialidad;
        this.temperatura = temperatura;
        this.diagnostico = diagnostico;
    }

    public HistoriaRegistroDTO() {
    }
    
    
    
}

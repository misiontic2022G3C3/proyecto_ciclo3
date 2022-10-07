/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.web.entidad;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Ferney
 */

@Entity
@Table (name="historiasclinicas")
public class HistoriasClinicas {
    @Id    
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column (name = "id")
    private Long id;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fecha_consulta", nullable = false, length = 80)
    private Date fecha_consulta;
    
    @Column(name = "documento_paciente", nullable = false, length = 80, unique = true)
    private long documento_paciente;
    
    @Column(name = "especialidad", nullable = false, length = 80)
    private String especialidad;
    
    @Column(name = "temperatura", nullable = false, length = 80)
    private float temperatura; 
        
    @Column(name = "diagnostico", nullable = false, length = 500)
    private String diagnostico;
    
    @JoinColumn(name ="id_clinica")
    @ManyToOne(fetch = FetchType.LAZY, optional=false, cascade = CascadeType.ALL)
    private Clinicas clinica;

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

    public Clinicas getClinica() {
        return clinica;
    }

    public void setClinica(Clinicas clinica) {
        this.clinica = clinica;
    }

    
    public HistoriasClinicas() {
    }

    public HistoriasClinicas(Long id, Date fecha_consulta, long documento_paciente, String especialidad, float temperatura, String diagnostico, Clinicas clinica) {
        this.id = id;
        this.fecha_consulta = fecha_consulta;
        this.documento_paciente = documento_paciente;
        this.especialidad = especialidad;
        this.temperatura = temperatura;
        this.diagnostico = diagnostico;
        this.clinica = clinica;
    }

    public HistoriasClinicas(Date fecha_consulta, long documento_paciente, String especialidad, float temperatura, String diagnostico, Clinicas clinica) {
        this.fecha_consulta = fecha_consulta;
        this.documento_paciente = documento_paciente;
        this.especialidad = especialidad;
        this.temperatura = temperatura;
        this.diagnostico = diagnostico;
        this.clinica = clinica;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final HistoriasClinicas other = (HistoriasClinicas) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "HistoriasClinicas{" + "id=" + id + ", fecha_consulta=" + fecha_consulta + ", documento_paciente=" + documento_paciente + ", especialidad=" + especialidad + ", temperatura=" + temperatura + ", diagnostico=" + diagnostico + ", clinica=" + clinica + '}';
    }
    
    


    
    
    
}

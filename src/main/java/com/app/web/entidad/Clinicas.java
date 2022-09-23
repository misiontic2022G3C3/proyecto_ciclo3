/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.web.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Ferney
 */
@Entity
@Table (name="clinicas")
public class Clinicas {
    @Id    
    @Column(name = "NIT", nullable = false, length = 80, unique = true)
    private long nit;
	
    @Column(name = "RazonSocial", nullable = false, length = 80)
    private String razonSocial;
    
    @Column(name = "Email", nullable = false, length = 80, unique = true)
    private String email;
	
    @Column(name = "Direccion", nullable = false, length = 150)
    private String direccion;
	
    @Column(name = "Username", nullable = false, length = 80, unique = true)
    private String username;
    
    @Column(name = "Contrasena", nullable = false, length = 80)
    private String contrasena;

    public long getNit() {
        return nit;
    }

    public void setNit(long nit) {
        this.nit = nit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Clinicas() {
    }
    
    public Clinicas(long nit, String razonSocial, String email, String direccion, String username, String contrasena) {
        this.nit = nit;
        this.razonSocial = razonSocial;
        this.email = email;
        this.direccion = direccion;
        this.username = username;
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Clinicas{" + "nit=" + nit + ", razonSocial=" + razonSocial + ", email=" + email + ", direccion=" + direccion + ", username=" + username + ", contrasena=" + contrasena + '}';
    }
    
    
}

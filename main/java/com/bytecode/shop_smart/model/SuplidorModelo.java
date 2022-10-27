/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bytecode.shop_smart.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author rsaldana
 */
@Entity
@Table(name = "suplidor")
public class SuplidorModelo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    @Column(name = "suplidor_id", unique = true, nullable = false)
    private long suplidorId;
    
    @Column(name = "dia_credito")
    private int diaCredito;//
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "direccion")
    private String direccion;
    
    @Column(name = "telefono")
    private String telefono;
    
    @Column(name = "vendedor")
    private String vendedor;
    
    @Column(name = "telefono_vendedor")
    private String telefonoVendedor;
    
    @Column(name = "correo")
    private String correo;

    @Column(name = "estado")
    private boolean estado;
    
    @Column(name = "responsable")
    private String responsable;

    
    
    public long getSuplidorId() {
        return suplidorId;
    }

    public void setSuplidorId(long suplidorId) {
        this.suplidorId = suplidorId;
    }

    public int getDiaCredito() {
        return diaCredito;
    }

    public void setDiaCredito(int diaCredito) {
        this.diaCredito = diaCredito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getTelefonoVendedor() {
        return telefonoVendedor;
    }

    public void setTelefonoVendedor(String telefonoVendedor) {
        this.telefonoVendedor = telefonoVendedor;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }



    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }


    public boolean getEstado() {
        return this.estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}

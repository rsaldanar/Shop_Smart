/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bytecode.shop_smart.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author rsaldana
 */
@Entity
@Table(name = "almacen")
public class AlmacenModelo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "almacen_id", unique = true, nullable = false)
    private long almacenId;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "responsable")
    private String responsable;

    @Column(name = "estado")
    private boolean estado;

    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    
    public long getAlmacenId() {
        return almacenId;
    }

    public void setAlmacenId(long almacenId) {
        this.almacenId = almacenId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    

}

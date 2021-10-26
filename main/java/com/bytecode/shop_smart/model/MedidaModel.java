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

/**
 *
 * @author rsaldana
 */
@Entity
@Table(name = "medida")
public class MedidaModel implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "medida_id", unique = true, nullable = false)
    private Long medidaId;
    
    @Column(name = "presentacion")
    private String presentacion;
    
    @Column(name = "unidad")
    private String unidad;
    
    @Column(name = "responsable")
    private String responsable;
    
    @Column(name = "estado")
    private boolean estado;
    
    @Column(name = "fecha")
    private Date fecha;
    
    

    public long getMedidaId() {
        return medidaId;
    }

    public void setMedidaId(long medidaId) {
        this.medidaId = medidaId;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
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


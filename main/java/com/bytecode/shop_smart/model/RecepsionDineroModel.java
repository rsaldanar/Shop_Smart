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
 * @author rafael
 */
@Entity
@Table(name = "recepcion_dinero")
public class RecepsionDineroModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "recepcion_id", unique = true, nullable = false)
    private long recepcioncajaId;

    @Column(name = "responsable")
    String responsable;

    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    
    @Column(name = "dos_mil")
    private int dosMil;
    
    @Column(name = "un_mil")
    private int unMil;
    
    @Column(name = "quiniento")
    private int quiniento;
    
    @Column(name = "dos_ciento")
    private int dosCiento;
    
    @Column(name = "cien")
    private int cien;
    
    @Column(name = "cincuenta")
    private int cincuenta;
    
    @Column(name = "vente_y_cinco")
    private int venteycinco;
    
    @Column(name = "vente")
    private int vente;
    
    @Column(name = "diez")
    private int diez;

    @Column(name = "cinco")
    private int cinco;
    
    @Column(name = "uno")
    private int uno;
    
    @Column(name = "total")
    private int total;
    
    @Column(name = "estado")
    private boolean estado;
    
    

    public long getRecepcioncajaId() {
        return recepcioncajaId;
    }

    public void setRecepcioncajaId(long recepcioncajaId) {
        this.recepcioncajaId = recepcioncajaId;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getDosMil() {
        return dosMil;
    }

    public void setDosMil(int dosMil) {
        this.dosMil = dosMil;
    }

    public int getUnMil() {
        return unMil;
    }

    public void setUnMil(int unMil) {
        this.unMil = unMil;
    }

    public int getQuiniento() {
        return quiniento;
    }

    public void setQuiniento(int quiniento) {
        this.quiniento = quiniento;
    }

    public int getDosCiento() {
        return dosCiento;
    }

    public void setDosCiento(int dosCiento) {
        this.dosCiento = dosCiento;
    }

    public int getCien() {
        return cien;
    }

    public void setCien(int cien) {
        this.cien = cien;
    }

    public int getCincuenta() {
        return cincuenta;
    }

    public void setCincuenta(int cincuenta) {
        this.cincuenta = cincuenta;
    }

    public int getVenteycinco() {
        return venteycinco;
    }

    public void setVenteycinco(int venteycinco) {
        this.venteycinco = venteycinco;
    }

    public int getVente() {
        return vente;
    }

    public void setVente(int vente) {
        this.vente = vente;
    }

    public int getDiez() {
        return diez;
    }

    public void setDiez(int diez) {
        this.diez = diez;
    }

    public int getCinco() {
        return cinco;
    }

    public void setCinco(int cinco) {
        this.cinco = cinco;
    }

    public int getUno() {
        return uno;
    }

    public void setUno(int uno) {
        this.uno = uno;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}

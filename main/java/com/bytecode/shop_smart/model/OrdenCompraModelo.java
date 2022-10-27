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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author rsaldana
 */
@Entity
@Table(name = "orden_compra")
public class OrdenCompraModelo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
    @Column(name = "orden_compra_id", unique = true, nullable = false )
    private long ordenId;

    @Column(name = "numero")
    private int numeroOrden;

    @ManyToOne
    @JoinColumn(name = "suplidor_id_suplidor")
    private SuplidorModelo suplidorModelo;

    @ManyToOne
    @JoinColumn(name = "articulo_id_articulo")
    private ArticuloModelo articuloModelo;

    @Column(name = "cantidad")
    private double cantidad;

    @Column(name = "precio")
    private double precio;

    @Column(name = "monto")
    private double monto;

    @ManyToOne
    @JoinColumn(name = "almacen_id_almacen")
    private AlmacenModelo almacenModelo;

    @Column(name = "total")
    private double total;

    @Column(name = "proceso_actual")
    private String procesoActual;

    @Column(name = "responsable")
    private String responsable;

    @Column(name = "estado")
    private boolean estado;

    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    
    
    
    public long getOrdenId() {
        return ordenId;
    }

    public void setOrdenId(long ordenId) {
        this.ordenId = ordenId;
    }

    public int getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(int numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public SuplidorModelo getSuplidorModelo() {
        return suplidorModelo;
    }

    public void setSuplidorModelo(SuplidorModelo suplidorModelo) {
        this.suplidorModelo = suplidorModelo;
    }

    public ArticuloModelo getArticuloModelo() {
        return articuloModelo;
    }

    public void setArticuloModelo(ArticuloModelo articuloModelo) {
        this.articuloModelo = articuloModelo;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public AlmacenModelo getAlmacenModelo() {
        return almacenModelo;
    }

    public void setAlmacenModelo(AlmacenModelo almacenModelo) {
        this.almacenModelo = almacenModelo;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getProcesoActual() {
        return procesoActual;
    }

    public void setProcesoActual(String procesoActual) {
        this.procesoActual = procesoActual;
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

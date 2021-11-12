/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bytecode.shop_smart.model;

/**
 *
 * @author rsaldana
 */
public class OrdenCompraModelo {
    int ordenId,numeroOrden, suplidorId, articuloId, almacenId, suplidorDiaCredito;
    double cantidad, precio, monto, total;
    String procesoActual, responsable;

    public int getOrdenId() {
        return ordenId;
    }

    public void setOrdenId(int ordenId) {
        this.ordenId = ordenId;
    }

    public int getNumeroOrden() {
        return numeroOrden;
    }

    public void setNumeroOrden(int numeroOrden) {
        this.numeroOrden = numeroOrden;
    }

    public int getSuplidorId() {
        return suplidorId;
    }

    public void setSuplidorId(int suplidorId) {
        this.suplidorId = suplidorId;
    }

    public int getArticuloId() {
        return articuloId;
    }

    public void setArticuloId(int articuloId) {
        this.articuloId = articuloId;
    }

    public int getAlmacenId() {
        return almacenId;
    }

    public void setAlmacenId(int almacenId) {
        this.almacenId = almacenId;
    }

    public int getSuplidorDiaCredito() {
        return suplidorDiaCredito;
    }

    public void setSuplidorDiaCredito(int suplidorDiaCredito) {
        this.suplidorDiaCredito = suplidorDiaCredito;
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
    
   
}

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
public class MovimientoModelo {
    int movimientoId, factura_numero;
    String responsable;

    public int getMovimientoId() {
        return movimientoId;
    }

    public void setMovimientoId(int movimientoId) {
        this.movimientoId = movimientoId;
    }

    public int getFactura_numero() {
        return factura_numero;
    }

    public void setFactura_numero(int factura_numero) {
        this.factura_numero = factura_numero;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }
    
    
}

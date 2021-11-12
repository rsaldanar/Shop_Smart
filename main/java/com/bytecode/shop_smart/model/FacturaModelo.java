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
public class FacturaModelo {

    int facturaId, factura_numero, clienteId, articuloId, movimientoId;
    double articuloCantidad, articuloPrecio, efectivo, cambio, cantidadArticulo;
    String responsable;

    public int getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(int facturaId) {
        this.facturaId = facturaId;
    }

    public int getFactura_numero() {
        return factura_numero;
    }

    public void setFactura_numero(int factura_numero) {
        this.factura_numero = factura_numero;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getArticuloId() {
        return articuloId;
    }

    public void setArticuloId(int articuloId) {
        this.articuloId = articuloId;
    }

    public int getMovimientoId() {
        return movimientoId;
    }

    public void setMovimientoId(int movimientoId) {
        this.movimientoId = movimientoId;
    }

    public double getArticuloCantidad() {
        return articuloCantidad;
    }

    public void setArticuloCantidad(double articuloCantidad) {
        this.articuloCantidad = articuloCantidad;
    }

    public double getArticuloPrecio() {
        return articuloPrecio;
    }

    public void setArticuloPrecio(double articuloPrecio) {
        this.articuloPrecio = articuloPrecio;
    }

    public double getEfectivo() {
        return efectivo;
    }

    public void setEfectivo(double efectivo) {
        this.efectivo = efectivo;
    }

    public double getCambio() {
        return cambio;
    }

    public void setCambio(double cambio) {
        this.cambio = cambio;
    }

    public double getCantidadArticulo() {
        return cantidadArticulo;
    }

    public void setCantidadArticulo(double cantidadArticulo) {
        this.cantidadArticulo = cantidadArticulo;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

}

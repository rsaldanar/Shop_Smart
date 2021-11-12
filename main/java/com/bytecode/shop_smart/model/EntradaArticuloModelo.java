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
public class EntradaArticuloModelo {

    int movimientoId, almacenIdAlmacen, articuloIdArticulo, ordenCompraNumero, movimiento_numero;
    double precioCompra, precioVentaA, precioVentaB, cantidadSalida, cantidadEntrada;
    String codigoEntrada, codigoSalida, documentoEntrada, 
            documentoSalida, fechaVencimiento, responsable, almacenNombre, procesoOrdenCompra;

    public int getMovimientoId() {
        return movimientoId;
    }

    public void setMovimientoId(int movimientoId) {
        this.movimientoId = movimientoId;
    }

    public int getAlmacenIdAlmacen() {
        return almacenIdAlmacen;
    }

    public void setAlmacenIdAlmacen(int almacenIdAlmacen) {
        this.almacenIdAlmacen = almacenIdAlmacen;
    }

    public int getArticuloIdArticulo() {
        return articuloIdArticulo;
    }

    public void setArticuloIdArticulo(int articuloIdArticulo) {
        this.articuloIdArticulo = articuloIdArticulo;
    }

    public int getOrdenCompraNumero() {
        return ordenCompraNumero;
    }

    public void setOrdenCompraNumero(int ordenCompraNumero) {
        this.ordenCompraNumero = ordenCompraNumero;
    }
    

    public String getCodigoEntrada() {
        return codigoEntrada;
    }

    public void setCodigoEntrada(String codigoEntrada) {
        this.codigoEntrada = codigoEntrada;
    }

    public String getCodigoSalida() {
        return codigoSalida;
    }

    public void setCodigoSalida(String codigoSalida) {
        this.codigoSalida = codigoSalida;
    }

    public String getDocumentoEntrada() {
        return documentoEntrada;
    }

    public void setDocumentoEntrada(String documentoEntrada) {
        this.documentoEntrada = documentoEntrada;
    }


    public String getDocumentoSalida() {
        return documentoSalida;
    }

    public void setDocumentoSalida(String documentoSalida) {
        this.documentoSalida = documentoSalida;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVentaA() {
        return precioVentaA;
    }

    public void setPrecioVentaA(double precioVentaA) {
        this.precioVentaA = precioVentaA;
    }

    public double getPrecioVentaB() {
        return precioVentaB;
    }

    public void setPrecioVentaB(double precioVentaB) {
        this.precioVentaB = precioVentaB;
    }

    public double getCantidadSalida() {
        return cantidadSalida;
    }

    public void setCantidadSalida(double cantidadSalida) {
        this.cantidadSalida = cantidadSalida;
    }

    public double getCantidadEntrada() {
        return cantidadEntrada;
    }

    public void setCantidadEntrada(double cantidadEntrada) {
        this.cantidadEntrada = cantidadEntrada;
    }

    

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getAlmacenNombre() {
        return almacenNombre;
    }

    public void setAlmacenNombre(String almacenNombre) {
        this.almacenNombre = almacenNombre;
    }

    public String getProcesoOrdenCompra() {
        return procesoOrdenCompra;
    }

    public void setProcesoOrdenCompra(String procesoOrdenCompra) {
        this.procesoOrdenCompra = procesoOrdenCompra;
    }

    public int getMovimiento_numero() {
        return movimiento_numero;
    }

    public void setMovimiento_numero(int movimiento_numero) {
        this.movimiento_numero = movimiento_numero;
    }
    
    

}

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
@Table(name = "movimiento")
public class MovimientoModelo implements Serializable{
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "movimiento_id", unique = true, nullable = false)
    private long movimientoId;
    
    @Column(name = "documento_entrada")
    private String documentoEntrada;
    
//    @ManyToOne
//    @JoinColumn(name = "almacen_id_almacen")
//    private AlmacenModelo almacenModelo;
    
    @ManyToOne
    @JoinColumn(name = "orden_compra_id_orden_compra")
    private OrdenCompraModelo ordenCompraModelo;
    
//    @ManyToOne
//    @JoinColumn(name = "articulo_id_articulo")
//    private ArticuloModelo articuloModelo;
    
    @Column(name = "precio_compra")
    private Float precioCompra;
    
    @Column(name = "precio_venta_a")
    private Float precioVentaA;
    
    @Column(name = "precio_venta_b")
    private Float precioVentaB;
    
    @Column(name = "comentario")
    private String comentario;
    
    @Column(name = "fecha_vencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    
    @Column(name = "responsable")
    private String responsable;

    @Column(name = "estado")
    private boolean estado;
    
    @Column(name = "movimiento_numero")
    private int movimientoNumero;
    
    @Column(name = "articulo_cantidad_entrada")
    private Float articuloCantidadEntrada;
    
    @Column(name = "articulo_cantidad_salida")
    private Float articuloCantidadSalida;
    
    @Column(name = "salida_numero")
    private int salidaNumero;

    public long getMovimientoId() {
        return movimientoId;
    }

    public void setMovimientoId(long movimientoId) {
        this.movimientoId = movimientoId;
    }

    public String getDocumentoEntrada() {
        return documentoEntrada;
    }

    public void setDocumentoEntrada(String documentoEntrada) {
        this.documentoEntrada = documentoEntrada;
    }

    public OrdenCompraModelo getOrdenCompraModelo() {
        return ordenCompraModelo;
    }

    public void setOrdenCompraModelo(OrdenCompraModelo ordenCompraModelo) {
        this.ordenCompraModelo = ordenCompraModelo;
    }

    public Float getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Float precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Float getPrecioVentaA() {
        return precioVentaA;
    }

    public void setPrecioVentaA(Float precioVentaA) {
        this.precioVentaA = precioVentaA;
    }

    public Float getPrecioVentaB() {
        return precioVentaB;
    }

    public void setPrecioVentaB(Float precioVentaB) {
        this.precioVentaB = precioVentaB;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
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

    public int getMovimientoNumero() {
        return movimientoNumero;
    }

    public void setMovimientoNumero(int movimientoNumero) {
        this.movimientoNumero = movimientoNumero;
    }

    public Float getArticuloCantidadEntrada() {
        return articuloCantidadEntrada;
    }

    public void setArticuloCantidadEntrada(Float articuloCantidadEntrada) {
        this.articuloCantidadEntrada = articuloCantidadEntrada;
    }

    public Float getArticuloCantidadSalida() {
        return articuloCantidadSalida;
    }

    public void setArticuloCantidadSalida(Float articuloCantidadSalida) {
        this.articuloCantidadSalida = articuloCantidadSalida;
    }

    public int getSalidaNumero() {
        return salidaNumero;
    }

    public void setSalidaNumero(int salidaNumero) {
        this.salidaNumero = salidaNumero;
    }
}

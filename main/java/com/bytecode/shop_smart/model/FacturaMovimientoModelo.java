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
@Table(name = "movimiento_salida")
public class FacturaMovimientoModelo implements Serializable{
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "movimiento_id", unique = true, nullable = false)
    private long movimientoId;
    
//    @Column(name = "documento_entrada")
//    private String documentoEntrada;
    
//    @ManyToOne
//    @JoinColumn(name = "almacen_id_almacen")
//    private AlmacenModelo almacenModelo;
    
//    @ManyToOne
//    @JoinColumn(name = "orden_compra_id_orden_compra")
//    private OrdenCompraModelo ordenCompraModelo;
    
//    @ManyToOne
//    @JoinColumn(name = "articulo_id_articulo")
//    private ArticuloModelo articuloModelo;
    @Column(name = "articulo_id_articulo")
    private Integer articuloId;
    
//    @Column(name = "precio_compra")
//    private float precioCompra;
    
    @Column(name = "precio_venta_a")
    private Float precioVentaA;
    
    @Column(name = "precio_venta_b")
    private Float precioVentaB;
    
    @Column(name = "comentario")
    private String comentario;
    
//    @Column(name = "fecha_vencimiento")
//    @Temporal(TemporalType.DATE)
//    private Date fechaVencimiento;
    
    @Column(name = "responsable")
    private String responsable;

    @Column(name = "estado")
    private boolean estado;
    
    @Column(name = "movimiento_numero")
    private Integer movimientoNumero;
//    
//    @Column(name = "articulo_cantidad_entrada")
//    private float articuloCantidadEntrada;
    
    @Column(name = "articulo_cantidad_salida")
    private Float articuloCantidadSalida;
    
    @Column(name = "salida_numero")
    private Integer salidaNumero;





    public long getMovimientoId() {
        return movimientoId;
    }

    public void setMovimientoId(long movimientoId) {
        this.movimientoId = movimientoId;
    }

    public Integer getArticuloId() {
        return articuloId;
    }

    public void setArticuloId(Integer articuloId) {
        this.articuloId = articuloId;
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

    public Integer getMovimientoNumero() {
        return movimientoNumero;
    }

    public void setMovimientoNumero(Integer movimientoNumero) {
        this.movimientoNumero = movimientoNumero;
    }

    public Float getArticuloCantidadSalida() {
        return articuloCantidadSalida;
    }

    public void setArticuloCantidadSalida(Float articuloCantidadSalida) {
        this.articuloCantidadSalida = articuloCantidadSalida;
    }

    public Integer getSalidaNumero() {
        return salidaNumero;
    }

    public void setSalidaNumero(Integer salidaNumero) {
        this.salidaNumero = salidaNumero;
    }
}

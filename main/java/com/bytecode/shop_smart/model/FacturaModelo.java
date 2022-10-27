/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bytecode.shop_smart.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author rsaldana
 */
@Entity
@Table(name = "factura")
public class FacturaModelo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "factura_id", unique = true, nullable = false)
    private long facturaId;

    @Column(name = "factura_numero")
    private Integer facturaNumero;

    @ManyToOne
    @JoinColumn(name = "cliente_id_cliente")
    private ClienteModel clienteModel;

    @ManyToOne
    @JoinColumn(name = "articulo_id_articulo")
    private ArticuloModelo articuloModelo;
    
//    @ManyToOne
//    @JoinColumn(name = "movimiento_id_movimiento")
//    private MovimientoModelo movimientoModelo;

    @Column(name = "articulo_cantidad")
    private double articuloCantidad;

    @Column(name = "articulo_precio")
    private double articuloPrecio;

    @Column(name = "efectivo")
    private double efectivo;

    @Column(name = "cambio")
    private double cambio;

//    @Column(name = "cantidadArticulo")
//    private int cantidadArticulo;

    @Column(name = "responsable")
    private String responsable;

    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(name = "estado")
    private boolean estado;

    
    
    
    
    
    public long getFacturaId() {
        return facturaId;
    }

    public void setFacturaId(long facturaId) {
        this.facturaId = facturaId;
    }

    public Integer getFacturaNumero() {
        return facturaNumero;
    }

    public void setFacturaNumero(Integer facturaNumero) {
        this.facturaNumero = facturaNumero;
    }

    public ClienteModel getClienteModel() {
        return clienteModel;
    }

    public void setClienteModel(ClienteModel clienteModel) {
        this.clienteModel = clienteModel;
    }

    public ArticuloModelo getArticuloModelo() {
        return articuloModelo;
    }

    public void setArticuloModelo(ArticuloModelo articuloModelo) {
        this.articuloModelo = articuloModelo;
    }

//    public MovimientoModelo getMovimientoModelo() {
//        return movimientoModelo;
//    }
//
//    public void setMovimientoModelo(MovimientoModelo movimientoModelo) {
//        this.movimientoModelo = movimientoModelo;
//    }

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

    public double getPriva() {
        return cambio;
    }

    public void setPriva(double priva) {
        this.cambio = priva;
    }

//    public int getCantidadArticulo() {
//        return cantidadArticulo;
//    }
//
//    public void setCantidadArticulo(int cantidadArticulo) {
//        this.cantidadArticulo = cantidadArticulo;
//    }

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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
    
    
}

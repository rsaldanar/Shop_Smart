package com.bytecode.shop_smart.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "cuadre_factura")
public class CuadreFacturaModelo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cuadre_factura", unique = true, nullable = false )
    private long cuadreId;

    @Column(name = "responsable")// Usuario
    private String responsable;

    @Column(name = "fecha_emision") // Fecha de emision de la factura
    @Temporal(TemporalType.DATE)
    private Date fechaEmision;

    @Column(name = "numero_factura")
    private int numeroFactura;

    @Column(name = "total_caja_inicial") // Total para iniciar la caja
    private double totalCajaInicial;

    // monto de la factura
    @Column(name = "total_factura")
    private double totalFactura;

    // monto recibido
    @Column(name = "total_recibido")
    private double totalRecibido;

    // cambio de la factura
    @Column(name = "cambio")
    private double cambio;

    @Column(name = "total_caja_final") // Total para finalizar la caja
    private double totalCajaFinal;

    @Column(name = "fecha_cierre") // Fecha de cierre de la factura
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCierre;

    // estado boolean
    @Column(name = "estado_cuadre")
    private boolean estadoCuadre;

    public long getCuadreId() {
        return cuadreId;
    }

    public void setCuadreId(long cuadreId) {
        this.cuadreId = cuadreId;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public double getTotalCajaInicial() {
        return totalCajaInicial;
    }

    public void setTotalCajaInicial(double totalCajaInicial) {
        this.totalCajaInicial = totalCajaInicial;
    }

    public double getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(double totalFactura) {
        this.totalFactura = totalFactura;
    }

    public double getTotalRecibido() {
        return totalRecibido;
    }

    public void setTotalRecibido(double totalRecibido) {
        this.totalRecibido = totalRecibido;
    }

    public double getCambio() {
        return cambio;
    }

    public void setCambio(double cambio) {
        this.cambio = cambio;
    }

    public double getTotalCajaFinal() {
        return totalCajaFinal;
    }

    public void setTotalCajaFinal(double totalCajaFinal) {
        this.totalCajaFinal = totalCajaFinal;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }


    public boolean isEstadoCuadre() {
        return estadoCuadre;
    }

    public void setEstadoCuadre(boolean estadoCuadre) {
        this.estadoCuadre = estadoCuadre;
    }
}

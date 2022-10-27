/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bytecode.shop_smart.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author rsaldana
 */
@Entity
@Table(name = "movimiento_contador")
public class MovimientoContadorModelo implements Serializable{
     
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "movimiento_contador_id", unique = true, nullable = false)
    private long movimientoContadorId;
    
    @Column(name = "contador")
    private int contador;
    
    

    public long getMovimientoContadorId() {
        return movimientoContadorId;
    }

    public void setMovimientoContadorId(long movimientoContadorId) {
        this.movimientoContadorId = movimientoContadorId;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
    
    
}

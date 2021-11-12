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
public class ArticuloModelo {
    int articuloId, medidaId;
    String nombre, marca, responsable, medidaString, numeroMedidaId;

    public int getArticuloId() {
        return articuloId;
    }

    public void setArticuloId(int articuloId) {
        this.articuloId = articuloId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public int getMedidaId() {
        return medidaId;
    }

    public void setMedidaId(int medidaId) {
        this.medidaId = medidaId;
    }

    public String getMedidaString() {
        return medidaString;
    }

    public void setMedidaString(String medidaString) {
        this.medidaString = medidaString;
    }

    public String getNumeroMedidaId() {
        return numeroMedidaId;
    }

    public void setNumeroMedidaId(String numeroMedidaId) {
        this.numeroMedidaId = numeroMedidaId;
    }
    
    
    
}

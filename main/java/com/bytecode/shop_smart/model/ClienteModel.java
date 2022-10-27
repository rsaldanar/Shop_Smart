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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author rsaldana
 */
@Entity
@Table(name = "cliente")
public class ClienteModel implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cliente_id", unique = true, nullable = false)
    private long clienteId;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "apellido")
    private String apellido;
    
    @Column(name = "telefono")
    private String telefono;
    
    @Column(name = "correo")
    private String correo;
    
    @Column(name = "direccion")
    private String direccion;
    
    @Column(name = "nota")
    private String nota;
    
    @Column(name = "usuario")
    private String usuario;
    
    @Column(name = "clave")
    private String clave;
    
    @ManyToOne
    @JoinColumn(name = "tipo_usuario")/// estandalizar esta a Tabla.
    private TipoUsuarioModel tipoUsuarioModel;
    
    @Column(name = "precio_usuario")
    private String precioUsuario;
    
    @Column(name = "responsable")
    private String responsable;
    
    @Column(name = "estado")
    private boolean estado;
    
    @Column(name = "fecha")
    private Date fecha;
    
    
    
    
    
    
    // Todos los Get y Set \|/

    public long getClienteId() {
        return clienteId;
    }

    public void setClienteId(long clienteId) {
        this.clienteId = clienteId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public TipoUsuarioModel getTipoUsuarioModel() {
        return tipoUsuarioModel;
    }

    public void setTipoUsuarioModel(TipoUsuarioModel tipoUsuarioModel) {
        this.tipoUsuarioModel = tipoUsuarioModel;
    }
    
    public String getPrecioUsuario() {
        return precioUsuario;
    }

    public void setPrecioUsuario(String precioUsuario) {
        this.precioUsuario = precioUsuario;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
   
        
}
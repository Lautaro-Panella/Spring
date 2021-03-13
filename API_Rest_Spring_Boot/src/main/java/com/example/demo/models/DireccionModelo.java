/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.models;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @Panella Lautaro
 */

@Entity
@Table(name = "direccion")
public class DireccionModelo implements Serializable {
    
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    
    @Column(name = "tipo")
    private String tipo;
    
    @Column(name = "calle")
    private String calle;
    
    @Column(name = "numero")
    private int numero;
    
    @Column(name = "localidad")
    private String localidad;
    
    @Column(name = "ciudad")
    private String ciudad;
    
    @Column(name = "pais")
    private String pais;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "idUsuario")
    private UsuarioModelo usuario;

    public DireccionModelo() {
    }

    public DireccionModelo(Long id, String tipo, String calle, int numero, String localidad, String ciudad, String pais, UsuarioModelo usuario) {
        this.id = id;
        this.tipo = tipo;
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.ciudad = ciudad;
        this.pais = pais;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public UsuarioModelo getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModelo usuario) {
        this.usuario = usuario;
    }
    
}

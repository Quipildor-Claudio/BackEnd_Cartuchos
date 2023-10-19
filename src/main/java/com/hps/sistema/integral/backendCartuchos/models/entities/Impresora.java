package com.hps.sistema.integral.backendCartuchos.models.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "impresoras")
public class Impresora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Date fecha_creacion;
    @PrePersist
    public void prePersist(){
        this.fecha_creacion=new Date();
    }
    // Constructor
    public Impresora() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
}
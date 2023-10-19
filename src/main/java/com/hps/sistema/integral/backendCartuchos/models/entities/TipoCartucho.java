package com.hps.sistema.integral.backendCartuchos.models.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tipo_cartuchos")
public class TipoCartucho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;

    private Date fecha_creacion;

    @PrePersist
    public void prePersist(){
        this.fecha_creacion=new Date();
    }

    //Constructor
    public TipoCartucho() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
}
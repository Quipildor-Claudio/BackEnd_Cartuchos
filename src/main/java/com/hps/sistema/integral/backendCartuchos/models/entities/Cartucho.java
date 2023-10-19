package com.hps.sistema.integral.backendCartuchos.models.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "cartuchos")
public class Cartucho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String modelo;
    private String capacidad;
    @OneToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "color_id")
    private Color  color;

    @OneToOne
    @JoinColumn(name = "tipo_cartucho_id")
    private TipoCartucho tipoCartucho;

    private Date fecha_creacion;

    @PrePersist
    public void prePersist(){
        this.fecha_creacion=new Date();
    }
  // Constructor
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Cartucho() {
        color = new Color();
        tipoCartucho = new TipoCartucho();
    }
    public TipoCartucho getTipoCartucho() {
        return tipoCartucho;
    }

    public void setTipoCartucho(TipoCartucho tipoCartucho) {
        this.tipoCartucho = tipoCartucho;
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

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
}
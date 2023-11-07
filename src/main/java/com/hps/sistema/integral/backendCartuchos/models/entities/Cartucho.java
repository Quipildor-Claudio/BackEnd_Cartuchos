package com.hps.sistema.integral.backendCartuchos.models.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "cartuchos")
public class Cartucho implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelo;
    private String capacidad;

    private String descripcion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "color_id")
    private Color  color;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "marca_id")
    private  Marca  marca;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipo_cartucho_id")
    private TipoCartucho tipoCartucho;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipo_carga_id")
    private TipoCarga tipoCarga;


    private Date fecha_creacion;


    public Cartucho() {


    }
    public TipoCarga getTipoCarga() {
        return tipoCarga;
    }

    public void setTipoCarga(TipoCarga tipoCarga) {
        this.tipoCarga = tipoCarga;
    }


    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
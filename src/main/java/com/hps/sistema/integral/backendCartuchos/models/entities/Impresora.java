package com.hps.sistema.integral.backendCartuchos.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "impresoras")
public class Impresora implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String modelo;

    private String descripcion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipo_impresora_id")
    private TipoImpresora tipoImpresora;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "marca_id")
    private Marca marca;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToMany
    private List<Cartucho> cartuchos;

    private Date fecha_creacion;


    public Impresora() {

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

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public TipoImpresora getTipoImpresora() {
        return tipoImpresora;
    }

    public void setTipoImpresora(TipoImpresora tipoImpresora) {
        this.tipoImpresora = tipoImpresora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Cartucho> getCartuchos() {
        return cartuchos;
    }

    public void setCartuchos(List<Cartucho> cartuchos) {
        this.cartuchos = cartuchos;
    }

}
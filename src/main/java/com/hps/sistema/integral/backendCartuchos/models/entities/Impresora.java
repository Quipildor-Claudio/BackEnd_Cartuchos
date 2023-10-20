package com.hps.sistema.integral.backendCartuchos.models.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "impresoras")
public class Impresora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String modelo;
    private Date fecha_creacion;

    @OneToOne
    @JoinColumn(name = "tipo_impresora_id")
    private TipoImpresora tipoImpresora;

    @OneToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;

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
    public Impresora() {
        marca = new Marca();
        tipoImpresora= new TipoImpresora();
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
}
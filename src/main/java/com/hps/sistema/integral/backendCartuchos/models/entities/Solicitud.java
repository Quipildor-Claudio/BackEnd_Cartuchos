package com.hps.sistema.integral.backendCartuchos.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "solicitudes")
public class Solicitud implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private String observacion;
    private String justificacion;
    private Integer cantidad;


    @JsonIgnoreProperties(value={"solicitudes", "hibernateLazyInitializer", "handler"}, allowSetters=true)
    @ManyToOne(fetch = FetchType.LAZY)
    private User usuario;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "estado_id")
    private Estado estado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tipo_carga_id")
    private TipoCarga tipoCarga;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToMany
    private List<Cartucho> cartuchos;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToMany
    private List<Impresora> impresoras;



    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Temporal(TemporalType.DATE)
    private Date fecha_actualizacion;

    public TipoCarga getTipoCarga() {
        return tipoCarga;
    }

    public void setTipoCarga(TipoCarga tipoCarga) {
        this.tipoCarga = tipoCarga;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }


    @PrePersist
    public void prePersist(){
        this.fechaCreacion=new Date();
    }

    public Solicitud() {

    }


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

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFecha_actualizacion() {
        return fecha_actualizacion;
    }

    public void setFecha_actualizacion(Date fecha_actualizacion) {
        this.fecha_actualizacion = fecha_actualizacion;
    }

    public List<Cartucho> getCartuchos() {
        return cartuchos;
    }

    public void setCartuchos(List<Cartucho> cartuchos) {
        this.cartuchos = cartuchos;
    }

    public List<Impresora> getImpresoras() {
        return impresoras;
    }

    public void setImpresoras(List<Impresora> impresoras) {
        this.impresoras = impresoras;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }




}
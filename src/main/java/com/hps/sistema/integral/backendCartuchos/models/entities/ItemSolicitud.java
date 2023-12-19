package com.hps.sistema.integral.backendCartuchos.models.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "item_solicitud")
public class ItemSolicitud implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private Integer cantidad;




    @ManyToOne
    @JoinColumn(name = "cartucho_id")
    private Cartucho cartucho;



    @ManyToOne
    @JoinColumn(name = "tipo_carga_id")
    private  TipoCarga  tipoCarga;



    public ItemSolicitud() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cartucho getCartucho() {
        return cartucho;
    }

    public void setCartucho(Cartucho cartucho) {
        this.cartucho = cartucho;
    }
    public TipoCarga getTipoCarga() {
        return tipoCarga;
    }

    public void setTipoCarga(TipoCarga tipoCarga) {
        this.tipoCarga = tipoCarga;
    }




}
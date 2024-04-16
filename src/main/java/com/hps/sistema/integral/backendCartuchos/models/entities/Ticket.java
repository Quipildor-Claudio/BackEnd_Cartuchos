package com.hps.sistema.integral.backendCartuchos.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="tickets")
public class Ticket implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tecnico_asignado;
    private String problema_reportado;
    private String observacion;
    private  String diagnostico;
    private String derivado;
    @Temporal(TemporalType.DATE)
    private Date fecha_solicitud;
    @Temporal(TemporalType.DATE)
    private  Date fecha_atencion;
    @Temporal(TemporalType.DATE)
    private Date fecha_salida;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToMany
    private List<Equipo> equipos;

    @JsonIgnoreProperties(value={"tickets", "hibernateLazyInitializer", "handler"}, allowSetters=true)
    @ManyToOne(fetch = FetchType.LAZY)
    private User usuario;

    public Ticket() {

    }

    @PrePersist
    public void prePersist(){
        this.fecha_solicitud=new Date();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public String getTecnico_asignado() {
        return tecnico_asignado;
    }

    public void setTecnico_asignado(String tecnico_asignado) {
        this.tecnico_asignado = tecnico_asignado;
    }

    public String getProblema_reportado() {
        return problema_reportado;
    }

    public void setProblema_reportado(String problema_reportado) {
        this.problema_reportado = problema_reportado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getDerivado() {
        return derivado;
    }

    public void setDerivado(String derivado) {
        this.derivado = derivado;
    }

    public Date getFecha_solicitud() {
        return fecha_solicitud;
    }

    public void setFecha_solicitud(Date fecha_solicitud) {
        this.fecha_solicitud = fecha_solicitud;
    }

    public Date getFecha_atencion() {
        return fecha_atencion;
    }

    public void setFecha_atencion(Date fecha_atencion) {
        this.fecha_atencion = fecha_atencion;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public List<Equipo> getEquipo() {
        return equipos;
    }

    public void setEquipo(List<Equipo> equipo) {
        this.equipos = equipo;
    }
}

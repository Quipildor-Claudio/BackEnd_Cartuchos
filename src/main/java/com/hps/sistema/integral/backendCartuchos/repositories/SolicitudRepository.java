package com.hps.sistema.integral.backendCartuchos.repositories;

import com.hps.sistema.integral.backendCartuchos.models.entities.Solicitud;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {

    public List<Solicitud> findByFechaCreacionBetween(Date fechaInicio, Date fechaFinal);

    public List<Solicitud> findByFechaCreacionBetweenAndUsuarioPersonaServicioNombre(Date fechaInicio, Date fechaFinal,String name);

    public List<Solicitud> findByEstadoDescripcion(String nombre);

    public List<Solicitud> findByEstadoDescripcionAndUsuarioUsername(String des,String name);

    public List<Solicitud> findByEstadoDescripcionAndUsuarioPersonaServicioNombre(String des, String name);

    public List<Solicitud> findByUsuarioPersonaServicioNombre(String nombre);

    public Page<Solicitud> findByUsuarioPersonaServicioNombre(String nombre, Pageable pageable);

    public Page<Solicitud> findByUsuarioUsername(String nombre, Pageable pageable);

}

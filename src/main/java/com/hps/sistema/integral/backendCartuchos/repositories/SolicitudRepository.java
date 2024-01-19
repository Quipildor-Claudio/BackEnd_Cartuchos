package com.hps.sistema.integral.backendCartuchos.repositories;

import com.hps.sistema.integral.backendCartuchos.models.entities.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface SolicitudRepository extends JpaRepository<Solicitud,Long> {

    public List<Solicitud> findByFechaCreacionBetween(Date fechaInicio, Date fechaFinal);
    public List<Solicitud> findByEstadoDescripcion(String nombre);
}

package com.hps.sistema.integral.backendCartuchos.repositories;

import com.hps.sistema.integral.backendCartuchos.models.entities.Solicitud;
import org.springframework.data.repository.CrudRepository;

public interface SolicitudRepository extends CrudRepository<Solicitud,Long> {
}

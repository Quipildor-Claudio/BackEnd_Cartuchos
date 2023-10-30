package com.hps.sistema.integral.backendCartuchos.services;


import com.hps.sistema.integral.backendCartuchos.models.entities.Solicitud;

import java.util.List;
import java.util.Optional;

public interface SolicitudService {
    List<Solicitud> listar();
    Optional<Solicitud> porId(Long id);
    Solicitud guardar(Solicitud data);
    void eliminar(Long id);
}

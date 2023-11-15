package com.hps.sistema.integral.backendCartuchos.services;


import com.hps.sistema.integral.backendCartuchos.models.entities.Servicio;

import java.util.List;
import java.util.Optional;

public interface ServicioService {
    List<Servicio> listar();
    Optional<Servicio> porId(Long id);
    Servicio guardar(Servicio data);
    void eliminar(Long id);

}

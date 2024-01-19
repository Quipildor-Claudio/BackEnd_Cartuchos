package com.hps.sistema.integral.backendCartuchos.services;


import com.hps.sistema.integral.backendCartuchos.models.entities.Servicio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ServicioService {
    List<Servicio> listar();
    Page<Servicio> listar(Pageable pageable);
    Optional<Servicio> porId(Long id);
    Servicio guardar(Servicio data);
    void eliminar(Long id);

}

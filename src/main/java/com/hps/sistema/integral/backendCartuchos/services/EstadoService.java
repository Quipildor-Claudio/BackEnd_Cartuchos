package com.hps.sistema.integral.backendCartuchos.services;


import com.hps.sistema.integral.backendCartuchos.models.entities.Estado;

import java.util.List;
import java.util.Optional;

public interface EstadoService {
    List<Estado> listar();
    Optional<Estado> porId(Long id);
    Estado guardar(Estado data);
    void eliminar(Long id);

}

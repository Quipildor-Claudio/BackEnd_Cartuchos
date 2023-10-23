package com.hps.sistema.integral.backendCartuchos.services;


import com.hps.sistema.integral.backendCartuchos.models.entities.Impresora;

import java.util.List;
import java.util.Optional;

public interface ImpresoraService {
    List<Impresora> listar();
    Optional<Impresora> porId(Long id);
    Impresora guardar(Impresora data);
    void eliminar(Long id);
}

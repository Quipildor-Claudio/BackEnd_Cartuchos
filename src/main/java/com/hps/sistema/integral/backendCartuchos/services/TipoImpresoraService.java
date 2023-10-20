package com.hps.sistema.integral.backendCartuchos.services;


import com.hps.sistema.integral.backendCartuchos.models.entities.TipoImpresora;

import java.util.List;
import java.util.Optional;

public interface TipoImpresoraService {
    List<TipoImpresora> listar();
    Optional<TipoImpresora> porId(Long id);
    TipoImpresora guardar(TipoImpresora tipoImpresora);
    void eliminar(Long id);
}

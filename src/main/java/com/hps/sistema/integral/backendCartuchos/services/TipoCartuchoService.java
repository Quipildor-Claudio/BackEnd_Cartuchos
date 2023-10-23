package com.hps.sistema.integral.backendCartuchos.services;


import com.hps.sistema.integral.backendCartuchos.models.entities.TipoCartucho;

import java.util.List;
import java.util.Optional;

public interface TipoCartuchoService {
    List<TipoCartucho> listar();
    Optional<TipoCartucho> porId(Long id);
    TipoCartucho guardar(TipoCartucho data);
    void eliminar(Long id);
}

package com.hps.sistema.integral.backendCartuchos.services;



import com.hps.sistema.integral.backendCartuchos.models.entities.TipoCarga;

import java.util.List;
import java.util.Optional;

public interface TipoCargeService {
    List<TipoCarga> listar();
    Optional<TipoCarga> porId(Long id);
    TipoCarga guardar(TipoCarga data);
    void eliminar(Long id);
}

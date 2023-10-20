package com.hps.sistema.integral.backendCartuchos.services;

import com.hps.sistema.integral.backendCartuchos.models.entities.Marca;

import java.util.List;
import java.util.Optional;

public interface MarcaService {
    List<Marca> listar();
    Optional<Marca> porId(Long id);
    Marca guardar(Marca marca);
    void eliminar(Long id);
}

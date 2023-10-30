package com.hps.sistema.integral.backendCartuchos.services;


import com.hps.sistema.integral.backendCartuchos.models.entities.Division;
import com.hps.sistema.integral.backendCartuchos.models.entities.User;

import java.util.List;
import java.util.Optional;

public interface DivisionService {
    List<Division> listar();
    Optional<Division> porId(Long id);
    Division guardar(Division data);
    void eliminar(Long id);
    Optional<Division> findByDescripcion(String descripcion);
}

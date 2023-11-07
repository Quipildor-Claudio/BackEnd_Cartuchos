package com.hps.sistema.integral.backendCartuchos.services;

import com.hps.sistema.integral.backendCartuchos.models.entities.Rol;

import java.util.List;
import java.util.Optional;

public interface RolService {
    List<Rol> listar();
    Optional<Rol> porId(Long id);

   Rol guardar(Rol rol);
    void eliminar(Long id);
}

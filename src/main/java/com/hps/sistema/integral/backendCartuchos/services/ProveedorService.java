package com.hps.sistema.integral.backendCartuchos.services;


import com.hps.sistema.integral.backendCartuchos.models.entities.Proveedor;

import java.util.List;
import java.util.Optional;

public interface ProveedorService {
    List<Proveedor> listar();
    Optional<Proveedor> porId(Long id);
    Proveedor guardar(Proveedor data);
    void eliminar(Long id);
}

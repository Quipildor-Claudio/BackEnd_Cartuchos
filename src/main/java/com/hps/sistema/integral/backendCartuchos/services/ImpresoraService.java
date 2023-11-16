package com.hps.sistema.integral.backendCartuchos.services;


import com.hps.sistema.integral.backendCartuchos.models.entities.Impresora;

import java.util.List;
import java.util.Optional;

public interface ImpresoraService {
    List<Impresora> listar();
    Optional<Impresora> porId(Long id);
    Impresora guardar(Impresora impresora);
    void eliminar(Long id);

    public List<Impresora> findByMarcaNombreAndModeloContainingIgnoreCase(String nombre,String modelo);
    public List<Impresora> findByMarcaNombreContainingIgnoreCase(String nombre);
    public List<Impresora> findByModeloContainingIgnoreCase(String modelo);

}

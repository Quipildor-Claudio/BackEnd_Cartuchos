package com.hps.sistema.integral.backendCartuchos.services;


import com.hps.sistema.integral.backendCartuchos.models.entities.Impresora;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ImpresoraService {
    List<Impresora> listar();

    Page<Impresora> listar(Pageable pageable);
    Optional<Impresora> porId(Long id);
    Impresora guardar(Impresora impresora);
    void eliminar(Long id);

    public List<Impresora> findByMarcaNombreAndModeloContainingIgnoreCase(String nombre,String modelo);
    public List<Impresora> findByMarcaNombreContainingIgnoreCase(String nombre);
    public List<Impresora> findByModeloContainingIgnoreCase(String modelo);

}

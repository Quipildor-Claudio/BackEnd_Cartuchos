package com.hps.sistema.integral.backendCartuchos.services;


import com.hps.sistema.integral.backendCartuchos.models.entities.Cartucho;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CartuchoService {
    List<Cartucho> listar();

    Page<Cartucho> listar(Pageable pageable);
    Optional<Cartucho> porId(Long id);
    Cartucho guardar(Cartucho data);
    void eliminar(Long id);
    public List<Cartucho> findByMarcaNombreAndModeloContainingIgnoreCase(String nombre, String modelo);
    public List<Cartucho> findByMarcaNombreContainingIgnoreCase(String nombre);
    public List<Cartucho> findByModeloContainingIgnoreCase(String modelo);
}

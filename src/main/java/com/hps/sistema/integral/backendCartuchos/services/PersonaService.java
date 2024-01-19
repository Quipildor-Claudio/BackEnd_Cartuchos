package com.hps.sistema.integral.backendCartuchos.services;


import com.hps.sistema.integral.backendCartuchos.models.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PersonaService {
    List<Persona> listar();
    Page<Persona> listar(Pageable pageable);
    Optional<Persona> porId(Long id);
    Persona guardar(Persona data);
    void eliminar(Long id);

    Optional<Persona> findByDni(String dni);
    List<Persona> findByDniContainingIgnoreCase(String dni);
}

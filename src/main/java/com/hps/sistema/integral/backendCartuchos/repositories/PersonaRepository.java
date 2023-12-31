package com.hps.sistema.integral.backendCartuchos.repositories;

import com.hps.sistema.integral.backendCartuchos.models.entities.Persona;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PersonaRepository extends CrudRepository<Persona,Long> {

    public Optional<Persona> findByDni(String dni);
    public List<Persona> findByDniContainingIgnoreCase(String dni);
}

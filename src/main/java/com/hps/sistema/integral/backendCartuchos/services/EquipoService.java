package com.hps.sistema.integral.backendCartuchos.services;

import com.hps.sistema.integral.backendCartuchos.models.entities.Equipo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface EquipoService {
    List<Equipo> listar();
    Optional<Equipo> porId(Long id);
    Equipo guardar(Equipo data);
    void eliminar(Long id);
    List<Equipo> findByCueContainingIgnoreCase(String cue);
    List<Equipo> findByMatriculaContainingIgnoreCase(String mat);
}

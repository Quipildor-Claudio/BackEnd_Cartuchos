package com.hps.sistema.integral.backendCartuchos.repositories;

import com.hps.sistema.integral.backendCartuchos.models.entities.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipoRepository extends JpaRepository<Equipo,Long> {
    public List<Equipo> findByCueContainingIgnoreCase(String cue);
    public List<Equipo> findByMatriculaContainingIgnoreCase(String mat);
}

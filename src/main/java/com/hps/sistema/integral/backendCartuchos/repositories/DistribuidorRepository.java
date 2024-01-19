package com.hps.sistema.integral.backendCartuchos.repositories;

import com.hps.sistema.integral.backendCartuchos.models.entities.Distribuidor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistribuidorRepository extends JpaRepository<Distribuidor,Long> {
}

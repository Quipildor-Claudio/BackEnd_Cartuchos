package com.hps.sistema.integral.backendCartuchos.repositories;

import com.hps.sistema.integral.backendCartuchos.models.entities.TipoCartucho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoCartuchoRepository extends JpaRepository<TipoCartucho,Long> {
}

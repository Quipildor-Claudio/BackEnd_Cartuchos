package com.hps.sistema.integral.backendCartuchos.repositories;

import com.hps.sistema.integral.backendCartuchos.models.entities.Cartucho;
import org.springframework.data.repository.CrudRepository;

public interface CartuchoRepository extends CrudRepository<Cartucho,Long> {
}

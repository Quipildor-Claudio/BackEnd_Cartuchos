package com.hps.sistema.integral.backendCartuchos.repositories;

import com.hps.sistema.integral.backendCartuchos.models.entities.Marca;
import org.springframework.data.repository.CrudRepository;

public interface MarcaRepository extends CrudRepository<Marca,Long> {
}

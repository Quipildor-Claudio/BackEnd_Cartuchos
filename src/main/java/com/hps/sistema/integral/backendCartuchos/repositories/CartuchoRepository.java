package com.hps.sistema.integral.backendCartuchos.repositories;

import com.hps.sistema.integral.backendCartuchos.models.entities.Cartucho;
import com.hps.sistema.integral.backendCartuchos.models.entities.Impresora;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CartuchoRepository extends CrudRepository<Cartucho,Long> {
    public List<Cartucho> findByMarcaNombreAndModeloContainingIgnoreCase(String nombre, String modelo);
    public List<Cartucho> findByMarcaNombreContainingIgnoreCase(String nombre);
    public List<Cartucho> findByModeloContainingIgnoreCase(String modelo);
}

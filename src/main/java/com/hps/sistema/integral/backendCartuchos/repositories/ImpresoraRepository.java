package com.hps.sistema.integral.backendCartuchos.repositories;

import com.hps.sistema.integral.backendCartuchos.models.entities.Impresora;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ImpresoraRepository extends CrudRepository<Impresora,Long> {
    public List<Impresora> findByModeloAndMarcaNombreContainingIgnoreCase(String modelo,String nombre);
    public List<Impresora> findByMarcaNombreContainingIgnoreCase(String nombre);
    public List<Impresora> findByModeloContainingIgnoreCase(String modelo);




}

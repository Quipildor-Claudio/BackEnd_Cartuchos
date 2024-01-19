package com.hps.sistema.integral.backendCartuchos.repositories;

import com.hps.sistema.integral.backendCartuchos.models.entities.Cartucho;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartuchoRepository extends JpaRepository<Cartucho,Long> {
    public List<Cartucho> findByMarcaNombreAndModeloContainingIgnoreCase(String nombre, String modelo);
    public List<Cartucho> findByMarcaNombreContainingIgnoreCase(String nombre);
    public List<Cartucho> findByModeloContainingIgnoreCase(String modelo);
}

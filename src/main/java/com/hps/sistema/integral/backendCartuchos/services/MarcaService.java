package com.hps.sistema.integral.backendCartuchos.services;

import com.hps.sistema.integral.backendCartuchos.models.entities.Marca;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface MarcaService {
    List<Marca> listar();

    Page<Marca> listar(Pageable pageable);
    Optional<Marca> porId(Long id);
    Marca guardar(Marca marca);
    void eliminar(Long id);
}

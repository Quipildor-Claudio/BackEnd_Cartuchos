package com.hps.sistema.integral.backendCartuchos.services;

import com.hps.sistema.integral.backendCartuchos.models.entities.Color;


import java.util.List;
import java.util.Optional;

public interface ColorService {
    List<Color> listar();
    Optional<Color> porId(Long id);
    Color guardar(Color color);
    void eliminar(Long id);
}

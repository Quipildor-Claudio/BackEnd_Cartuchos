package com.hps.sistema.integral.backendCartuchos.services;

import com.hps.sistema.integral.backendCartuchos.models.entities.Color;

import com.hps.sistema.integral.backendCartuchos.repositories.ColorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ColorServiceImpl implements ColorService{
    @Autowired
    ColorRepository repository;

    @Override
    public List<Color> listar() {
        return (List<Color>) repository.findAll();
    }

    @Override
    public Optional<Color> porId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Color guardar(Color color) {
        return repository.save(color);
    }

    @Override
    public void eliminar(Long id) {
            repository.deleteById(id);
    }
}

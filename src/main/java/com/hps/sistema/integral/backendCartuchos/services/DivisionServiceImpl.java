package com.hps.sistema.integral.backendCartuchos.services;

import com.hps.sistema.integral.backendCartuchos.models.entities.Division;
import com.hps.sistema.integral.backendCartuchos.repositories.DivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DivisionServiceImpl implements DivisionService{
    @Autowired
    DivisionRepository repository;

    @Override
    public List<Division> listar() {
        return (List<Division>) repository.findAll();
    }

    @Override
    public Optional<Division> porId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Division guardar(Division data) {
        return repository.save(data);
    }

    @Override
    public void eliminar(Long id) {
            repository.deleteById(id);
    }

    @Override
    public Optional<Division> findByDescripcion(String descripcion) {
        return repository.findByDescripcion(descripcion);
    }
}

package com.hps.sistema.integral.backendCartuchos.services;

import com.hps.sistema.integral.backendCartuchos.models.entities.Persona;
import com.hps.sistema.integral.backendCartuchos.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
@Service
public class PersonaServiceImpl implements PersonaService{
    @Autowired
    PersonaRepository repository;

    @Override
    public List<Persona> listar() {
        return (List<Persona>) repository.findAll();
    }

    @Override
    public Page<Persona> listar(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Optional<Persona> porId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Persona guardar(Persona data) {
        return repository.save(data);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Persona> findByDni(String dni) {
        return repository.findByDni(dni);
    }

    @Override
    public List<Persona> findByDniContainingIgnoreCase(String dni) {
        return repository.findByDniContainingIgnoreCase(dni);
    }
}

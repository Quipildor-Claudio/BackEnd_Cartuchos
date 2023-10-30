package com.hps.sistema.integral.backendCartuchos.services;

import com.hps.sistema.integral.backendCartuchos.models.entities.Estado;
import com.hps.sistema.integral.backendCartuchos.repositories.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoSerciceImpl implements EstadoService{

    @Autowired
    EstadoRepository repository;

    @Override
    public List<Estado> listar() {
        return (List<Estado>) repository.findAll();
    }

    @Override
    public Optional<Estado> porId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Estado guardar(Estado data) {
        return repository.save(data);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}

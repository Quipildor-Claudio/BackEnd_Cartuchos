package com.hps.sistema.integral.backendCartuchos.services;

import com.hps.sistema.integral.backendCartuchos.models.entities.Rol;
import com.hps.sistema.integral.backendCartuchos.repositories.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImpl implements RolService{
    @Autowired
    RolRepository repository;
    @Override
    public List<Rol> listar() {
        return (List<Rol>) repository.findAll();
    }

    @Override
    public Optional<Rol> porId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Rol guardar(Rol rol) {
        return repository.save(rol);
    }

    @Override
    public void eliminar(Long id) {
            repository.deleteById(id);
    }
}

package com.hps.sistema.integral.backendCartuchos.services;

import com.hps.sistema.integral.backendCartuchos.models.entities.Proveedor;
import com.hps.sistema.integral.backendCartuchos.repositories.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorServiceImpl implements ProveedorService{
    @Autowired
    ProveedorRepository repository;
    @Override
    public List<Proveedor> listar() {
        return (List<Proveedor>) repository.findAll();
    }

    @Override
    public Optional<Proveedor> porId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Proveedor guardar(Proveedor data) {
        return repository.save(data);
    }

    @Override
    public void eliminar(Long id) {
                repository.deleteById(id);
    }
}

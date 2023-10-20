package com.hps.sistema.integral.backendCartuchos.services;

import com.hps.sistema.integral.backendCartuchos.models.entities.Marca;
import com.hps.sistema.integral.backendCartuchos.repositories.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaServiceImpl implements MarcaService{
    @Autowired
    private MarcaRepository repository;

    @Override
    public List<Marca> listar() {
        return (List<Marca>) repository.findAll();
    }

    @Override
    public Optional<Marca> porId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Marca guardar(Marca marca) {
        return repository.save(marca);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}

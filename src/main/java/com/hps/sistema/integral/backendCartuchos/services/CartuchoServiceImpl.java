package com.hps.sistema.integral.backendCartuchos.services;

import com.hps.sistema.integral.backendCartuchos.models.entities.Cartucho;
import com.hps.sistema.integral.backendCartuchos.repositories.CartuchoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CartuchoServiceImpl implements CartuchoService{
    @Autowired
    CartuchoRepository repository;

    @Override
    public List<Cartucho> listar() {
        return (List<Cartucho>) repository.findAll();
    }

    @Override
    public Optional<Cartucho> porId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Cartucho guardar(Cartucho data) {
        return repository.save(data);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}

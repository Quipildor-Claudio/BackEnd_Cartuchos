package com.hps.sistema.integral.backendCartuchos.services;

import com.hps.sistema.integral.backendCartuchos.models.entities.TipoCartucho;
import com.hps.sistema.integral.backendCartuchos.repositories.TipoCartuchoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoCartuchoServiceImpl implements TipoCartuchoService{
    @Autowired
    private TipoCartuchoRepository repository;


    @Override
    public List<TipoCartucho> listar() {
        return (List<TipoCartucho>) repository.findAll();
    }

    @Override
    public Optional<TipoCartucho> porId(Long id) {
        return repository.findById(id);
    }

    @Override
    public TipoCartucho guardar(TipoCartucho data) {
        return repository.save(data);
    }

    @Override
    public void eliminar(Long id) {
            repository.deleteById(id);
    }
}

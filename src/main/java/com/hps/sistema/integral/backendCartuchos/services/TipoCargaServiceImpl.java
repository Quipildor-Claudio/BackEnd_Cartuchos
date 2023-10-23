package com.hps.sistema.integral.backendCartuchos.services;

import com.hps.sistema.integral.backendCartuchos.models.entities.TipoCarga;
import com.hps.sistema.integral.backendCartuchos.repositories.TipoCargaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoCargaServiceImpl implements  TipoCargeService{
    @Autowired
    private TipoCargaRepository repository;
    @Override
    public List<TipoCarga> listar() {
        return (List<TipoCarga>) repository.findAll();
    }

    @Override
    public Optional<TipoCarga> porId(Long id) {
        return repository.findById(id);
    }

    @Override
    public TipoCarga guardar(TipoCarga data) {
        return repository.save(data);
    }

    @Override
    public void eliminar(Long id) {
            repository.deleteById(id);
    }
}

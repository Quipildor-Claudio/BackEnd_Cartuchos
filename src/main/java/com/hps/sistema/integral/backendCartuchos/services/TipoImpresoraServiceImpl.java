package com.hps.sistema.integral.backendCartuchos.services;

import com.hps.sistema.integral.backendCartuchos.models.entities.TipoImpresora;
import com.hps.sistema.integral.backendCartuchos.repositories.TipoImpresoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TipoImpresoraServiceImpl implements TipoImpresoraService{
    @Autowired
    TipoImpresoraRepository repository;

    @Override
    public List<TipoImpresora> listar() {
        return (List<TipoImpresora>) repository.findAll();
    }

    @Override
    public Optional<TipoImpresora> porId(Long id) {
        return repository.findById(id);
    }

    @Override
    public TipoImpresora guardar(TipoImpresora tipoImpresora) {
        return repository.save(tipoImpresora);
    }

    @Override
    public void eliminar(Long id) {
            repository.deleteById(id);
    }
}

package com.hps.sistema.integral.backendCartuchos.services;

import com.hps.sistema.integral.backendCartuchos.models.entities.Servicio;
import com.hps.sistema.integral.backendCartuchos.repositories.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ServicoServiceImpl implements  ServicioService{
    @Autowired
    ServicioRepository repository;
    @Override
    public List<Servicio> listar() {
        return (List<Servicio>) repository.findAll();
    }

    @Override
    public Optional<Servicio> porId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Servicio guardar(Servicio data) {
        return repository.save(data);
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}

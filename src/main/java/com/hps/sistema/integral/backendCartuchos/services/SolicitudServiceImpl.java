package com.hps.sistema.integral.backendCartuchos.services;

import com.hps.sistema.integral.backendCartuchos.models.entities.Solicitud;
import com.hps.sistema.integral.backendCartuchos.repositories.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitudServiceImpl implements SolicitudService {
    @Autowired
    SolicitudRepository repository;

    @Override
    public List<Solicitud> listar() {
        return (List<Solicitud>) repository.findAll();
    }

    @Override
    public Optional<Solicitud> porId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Solicitud guardar(Solicitud data) {
        return repository.save(data);
    }

    @Override
    public void eliminar(Long id) {
            repository.deleteById(id);
    }
}

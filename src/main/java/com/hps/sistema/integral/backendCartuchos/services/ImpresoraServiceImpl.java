package com.hps.sistema.integral.backendCartuchos.services;

import com.hps.sistema.integral.backendCartuchos.models.entities.Impresora;
import com.hps.sistema.integral.backendCartuchos.repositories.ImpresoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImpresoraServiceImpl implements  ImpresoraService {
    @Autowired
    ImpresoraRepository repository;

    @Override
    public List<Impresora> listar() {
        return (List<Impresora>) repository.findAll();
    }

    @Override
    public Optional<Impresora> porId(Long id) {
        return repository.findById(id);
    }

    @Override
    public Impresora guardar(Impresora impresora) {
        return repository.save(impresora);
    }

    @Override
    public void eliminar(Long id) {
            repository.deleteById(id);
    }

    @Override
    public List<Impresora> findByModeloAndMarcaNombreContainingIgnoreCase(String modelo, String nombre) {
        return repository.findByModeloAndMarcaNombreContainingIgnoreCase(modelo,nombre);
    }

    @Override
    public List<Impresora> findByMarcaNombreContainingIgnoreCase(String nombre) {
        return repository.findByMarcaNombreContainingIgnoreCase(nombre);
    }

    @Override
    public List<Impresora> findByModeloContainingIgnoreCase(String modelo) {
        return repository.findByModeloContainingIgnoreCase(modelo);
    }
}
